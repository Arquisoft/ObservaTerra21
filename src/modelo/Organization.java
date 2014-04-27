package modelo;

import java.util.List;

public class Organization {
	
	private int id;
	private String nombre;
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

}
