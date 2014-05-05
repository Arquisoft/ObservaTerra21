package controllers;

import java.sql.Date;
import java.util.Map;

import javax.persistence.NoResultException;

import model.Area;
import model.Indicator;
import model.Measure;
import model.Observation;
import model.Organization;
import model.Time;
import model.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static class UserR extends User {

	}

	public static class Org extends Organization {

	}
	
	public static class AreaR extends Area{
		
	}

	public static Result addOrganizacion() {
				return ok(orgadd.render(Organization.getAll()));
	}

	public static Result followOrg(String usuario, Integer code) {
		User user = User.findById(usuario);
		Organization org = Organization.getByID(code);
		user.addOrganization(org);
		
		return redirect(routes.Application.perfilUsuario());
	}

	public static Result unFollowOrg(String usuario, Integer code) {
		User user = User.findById(usuario);
		Organization org = Organization.getByID(code);
		user.removeOrganization(org);
		return redirect(routes.Application.perfilUsuario());
	}

	public static Result perfilUsuario() {
		User user = User.findById(session().get("usuario"));

		if(user == null){
			return redirect(routes.Application.login());
		}
		
		return ok(perfilUsuario.render(user._getOrganizations(),
				user._getNotMyOrganizations(), Observation.findByUser(user)));
	}
	
	public static Result logout(){
		session().remove("usuario");
		return redirect(routes.Application.index());
	}

	

	public static Result createOrganization() {
//		Form<Org> loginForm = Form.form(Org.class).bindFromRequest();

		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String nombre = values.get("nombre")[0];
		Organization organization = new Organization();
		organization.setNombre(nombre);
		Organization.create(organization);

		return redirect(routes.Application.perfilUsuario());
	}

	public static Result createUser() {

		Form<UserR> loginForm = Form.form(UserR.class).bindFromRequest();

		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String usuario = values.get("usuario")[0];
		String pass = values.get("password")[0];
		String nombre = values.get("nombre")[0];
		String apellidos = values.get("apellidos")[0];
		String email = values.get("email")[0];

		User user = new User();
		user.setNombre(nombre);
		user.setMail(email);
		user.setUsuario(usuario);
		user.setPassword(pass);
		user.setApellidos(apellidos);
		User.createUser(user);

		return redirect(routes.Application.index());

	}

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result register() {
		return ok(registro.render(Form.form(UserR.class)));
	}

	public static Result datos() {
		if(User.findById(session().get("usuario")) != null){
			return ok(datosLogin.render(Area.getAll(), Indicator.getAll(),null));
		}else{
			return ok(datos.render(Area.getAll(), Indicator.getAll(),null));
		}
		

	}
	
	public static Result compareAreas(){
		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String country1 = values.get("country1")[0];
		String country2 = values.get("country2")[0];
		String indicator = values.get("indicator")[0];
		Area area1 = Area.findByID(Long.parseLong(country1));
		Area area2 = Area.findByID(Long.parseLong(country2));
		Indicator ind = Indicator.getByID(Long.parseLong(indicator));
		
		try{
		return ok(comparador.render(Observation.getObservationsToCompare(area1, area2, ind), country1, country2,indicator));
		}catch(NoResultException e){
			return ok(datos.render(Area.getAll(), Indicator.getAll(),e.getMessage()));
		}

	}
	
	public static Result createObservation(){
		Form<Obs> loginForm = Form.form(Obs.class).bindFromRequest();
		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String area = values.get("area")[0];
		String indicador = values.get("indicador")[0];
		String medida = values.get("medida")[0];
		String unidad = values.get("unidad")[0];
		String time = values.get("time")[0];
		String organizacion = values.get("organizacion")[0];
		
		Area a = Area.findByName(area);
		if(a == null){
			a = new Area();
			a.setNombre(area);
			Area.create(a);
		}
		
		Indicator i = Indicator.findyByIndicator(indicador);
		if(i == null){
			i = new Indicator();
			i.setIndicador(indicador);
			Indicator.create(i);
		}
		
		Measure m = Measure.findByMeasure(medida);
		if(m == null){
			m = new Measure();
			m.setMedida(medida);
			m.setUnidad(unidad);
			Measure.create(m);
		}
		
		Time t = new Time(new Date(Date.parse(time)));
		Time.create(t);
		
		Organization o = Organization.getByName(organizacion);
		if(o == null){
			o = new Organization();
			o.setNombre(organizacion);
			Organization.create(o);
		}
		
		Observation ob = new Observation(a,i,m,t,o);
		
		Observation.create(ob);
		
		return redirect(routes.Application.perfilUsuario());
	}

	public static Result obsrv() {
		return ok(observaciones.render(Indicator.getAll()));
	}
	
	public static Result getObservationsPerIndicator(){
		Map<String, String[]> values = request().body().asFormUrlEncoded();
		
		String ind = values.get("indicator")[0];
		Indicator indicator = Indicator.getByID(Long.parseLong(ind));
		
		if(User.findById(session().get("usuario")) != null){
			return ok(observacionesPorIndicadorLogueado.render(Observation.findByIndicator(indicator)));
		}else{
			return ok(observacionesPorIndicador.render(Observation.findByIndicator(indicator)));
		}
		
		
	}

	public static Result validateUser() {
//		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String email = values.get("usuario")[0];
		String pass = values.get("password")[0];

		User us = User.findById(email);

		if (us != null && us.getPassword().equalsIgnoreCase(pass)) {
			session().put("usuario", email);
			return ok(perfilUsuario.render(us._getOrganizations(),
					us._getNotMyOrganizations(),Observation.findByUser(us)));
		} else
			return redirect(routes.Application.login());

	}

	static Form<Org> orgForm = Form.form(Org.class);
	static Form<AreaR> orgArea = Form.form(AreaR.class);
	static Form<Obs> formObs	= Form.form(Obs.class);
	
	public static Result addArea(){
		
		return ok(addArea.render(orgArea));
	}
	
	public static Result createArea(){
		Form<AreaR> loginForm = Form.form(AreaR.class).bindFromRequest();
		Map<String, String[]> values = request().body().asFormUrlEncoded();
		String nombre = values.get("nombre")[0];
		
		Area area = new Area();
		area.setNombre(nombre);
		Area.create(area);
		return redirect(routes.Application.perfilUsuario());
	}
	
	public static Result addObservacion(){
		
		return ok(observacionesUsuario.render(formObs, Observation.getAll(), Indicator.getAll()));
	}

	public static class Login {
		public String usuario;
		public String password;

		public String validate() {

			Map<String, String[]> values = request().body().asFormUrlEncoded();
			String email = values.get("usuario")[0];
			String pass = values.get("password")[0];

			User us = User.findById(email);

			java.util.List<model.Pertenece> orgs = us.getOrganizations();
			

			if (us.getPassword().equals(pass)) {
				return us.getUsuario(); // TODO OK
			} else {
				return "Invalid username or password";
			}

		}

	}
	
	
	
	public static class Obs{
		public String area;
		public String indicator;
		public String medida;
		public String unidad;
		public String time;
		public String organzacion;
	}

}