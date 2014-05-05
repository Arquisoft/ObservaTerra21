package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
@Table(name="Indicator")
public class Indicator extends Model {
	
	private static Finder<Long,Indicator> find =
            new Finder<Long,Indicator>(Long.class, Indicator.class);
	
	@Id @GeneratedValue
	private Long id;
	
	private String indicador;
	
	
	@OneToMany(mappedBy="indicator")
	private List<Observation>observaciones = new ArrayList<Observation>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    

    public Indicator(){

    }


	public Indicator(String indicador) {
		super();
		this.indicador = indicador;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	
	public static Indicator findyByIndicator(String indicator){
		return find.where().eq("indicador", indicator).findUnique();
	}
	
	public static void create(Indicator indicator){
		indicator.save();
	}
	
	public static List<Indicator> getAll(){
		return find.all();
	}
	
	public static Indicator getByID(Long id){
		return find.byId(id);
	}
	
	public String toString(){
		return "Ind:"+this.indicador;
	}


}
