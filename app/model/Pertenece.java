package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Pertenece extends Model{
	
	public static Finder<Long, Pertenece> find =
            new Finder<Long,Pertenece>(Long.class, Pertenece.class);
	
	public Pertenece(){
		
	}
	
	public Pertenece(User usuario, Organization org){
		this.usuario = usuario;
		this.org = org;
		link();
		this.save();
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private User usuario;
	
	@ManyToOne
	private Organization org;

	@Override
	public String toString() {
		return "Pertenece [id=" + id + ", usuario=" + usuario + ", org=" + org
				+ "]";
	}
	
	public void link(){
		org.getUsuarios().add(this);
		usuario.getOrganizations().add(this);
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}
	
	
	

	public static void delete(User user, Organization org2) {
		List<Pertenece> all = find.all();
		for(Pertenece p : all){
			if(p.getOrg().equals(org2) && p.getUsuario().equals(user)){
				Long id = p.getId().longValue();
				find.ref(id).delete();
			}
		}
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
