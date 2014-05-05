package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="Organization")
public class Organization extends Model{
	
	public static Finder<Long,Organization> find =
            new Finder<Long,Organization>(Long.class, Organization.class);
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	

	@OneToMany(mappedBy="org")
	private List<Pertenece> usuarios;
	

    public Organization(){
    	this.usuarios = new ArrayList<Pertenece>();
    }

    
    

	private List<Organization> organizaciones;
	public Organization(int id, String nombre, List<Organization> organizaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.organizaciones = organizaciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public static void create(Organization organization) {
		organization.save();
		
	}
	public static List<Organization> getAll() {
		return find.all();
	}
	public static Organization getByID(Integer code) {
		 return find.where().eq("id", code).findUnique();
	}
	
	@Override
	public String toString() {
		return this.nombre.toString();
	}
	public List<Pertenece> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Pertenece> usuarios) {
		this.usuarios = usuarios;
	}
	public static Organization getByName(String organizacion) {
		return find.where().eq("nombre", organizacion).findUnique();
	}
	
	
	

}
