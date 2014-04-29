package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;

public class Area extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String nombre;
	private List<Area> areas;

	public Area(String nombre, List<Area> areas) {
		super();
		this.nombre = nombre;
		this.areas = areas;
	}

	public Area() {

	}

	public Area(int id, String nombre, List<Area> areas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.areas = areas;
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

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public void addArea(Area area) {
		if (this.areas == null) {
			this.areas = new ArrayList<Area>();
		}
		this.areas.add(area);
	}

}
