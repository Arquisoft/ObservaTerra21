package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class Organization extends Model {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	public String id;
	public String nombre;
	public List<Organization> organizaciones;

	public Organization() {

	}

	public Organization(String id, String nombre,
			List<Organization> organizaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.organizaciones = organizaciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Organization> getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(List<Organization> organizaciones) {
		this.organizaciones = organizaciones;
	}

	// Código generado para play a partir de Country

	public static Finder<String, Organization> find = new Finder<String, Organization>(
			String.class, Organization.class);

	public static List<Organization> all() {
		return find.all();
	}

	public static void create(Organization organization) {
		if (Organization.findByName(organization.nombre) == null) {
			organization.save();
		}
	}

	public static void remove(String code) {
		find.ref(code).delete();
	}

	public static void deleteAll() {
		for (Organization c : all())
			c.delete();
	}

	public static Organization findByName(String name) {
		return find.where().eq("nombre", name).findUnique();
	}

	public static Organization findByCode(String code) {
		return find.byId(code);
	}

	public static JsonNode toJson(Organization organization) {
		return Json.toJson(organization);
	}

}
