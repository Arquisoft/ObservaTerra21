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
@Table(name="Measure")
public class Measure extends Model {
	
	private static Finder<Long,Measure> find =
            new Finder<Long,Measure>(Long.class, Measure.class);
	
	@Id @GeneratedValue
    private Long id;
	
	private String medida;
    private String unidad;
    
    
    @OneToMany(mappedBy="measure")
	private List<Observation>observaciones = new ArrayList<Observation>();

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }



	public Measure()
	{

	}

	public Measure(String medida) {
		super();
		this.medida = medida;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public static Measure findByMeasure(String medida){
    	return find.where().eq("medida", medida).findUnique();
    }
    
    public static void create(Measure measure){
    	measure.save();
    }

	public static List<Measure> getAll() {
		return find.all();
	}

}
