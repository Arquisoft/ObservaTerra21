package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import javax.persistence.*;
@Entity
public class User extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Required
	private String usuario;
	private String password;
	private String mail;
	private String nombre;
	private String apellidos;
	private Organization organizacion;

	public User() {

	}

	public User(int id, String usuario, String password, String mail,
			String nombre, String apellidos, Organization organizacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.mail = mail;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.organizacion = organizacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Organization getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organization organizacion) {
		this.organizacion = organizacion;
	}

}
