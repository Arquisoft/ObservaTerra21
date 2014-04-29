package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Measure extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* IMPORTANTE - Revisar la notación de persitencia */
	@Required
	private String medida;
	@Required
	private String unidad;
	@Id
	private long id;

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Measure() {

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

	public void setId(Integer id) {
		this.id = id;
	}

	// Generado para play

	public static Finder<Long, Measure> find = new Finder<Long, Measure>(
			Long.class, Measure.class);

	public Measure(String unidad, String medida, Long id) {
		this.id = id;
		this.unidad = unidad;
		this.medida = medida;
	}

	public static List<Measure> all() {
		return find.all();
	}

	public static Measure create(String unidad, String medida, Long id) {
		Measure measure = new Measure(unidad, medida, id);
		measure.save();
		return measure;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Measure meas : all()) {
			meas.delete();
		}
	}

	public static List<Measure> findByMeasureCore(Long measureCode) {
		Measure c = Measure.find.byId(measureCode);
		List<Measure> result = find.where().eq("measure", c).findList();
		return result;
	}
}
