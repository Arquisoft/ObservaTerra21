package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name="Area")
public class Area extends Model{
	
	private static Finder<Long,Area> find =
            new Finder<Long,Area>(Long.class, Area.class);
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	
//	private List<Area> areas;
	
	public Area(String nombre/*, List<Area> areas*/) {
		super();
		this.nombre = nombre;
//		this.areas = areas;
	}

    public Area(){

    }
	
	
	public Area(int id, String nombre, List<Area> areas) {
		super();
		this.id = id;
		this.nombre = nombre;
//		this.areas = areas;
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
	
	
	public static void create(Area area){
		area.save();
	}
	
	public static Area findByName(String name){
		return find.where().eq("nombre", name).findUnique();
	}
	
	public static List<Area> getAll(){
		return find.all();
	}
	
	public static Area findByID(Long id){
		return find.byId(id);
	}
	
	/*public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

    public void addArea(Area area){
        if(this.areas == null){
            this.areas = new ArrayList<Area>();
        }
        this.areas .add(area);
    }*/

}
