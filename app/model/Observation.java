package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Observation")
public class Observation extends Model {

	public static Finder<Long, Observation> find = new Finder<Long, Observation>(
			Long.class, Observation.class);

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Area area;
	@ManyToOne
	private Indicator indicator;
	@ManyToOne
	private Measure measure;
	@ManyToOne
	private Time time;
	@ManyToOne
	private Organization provider;

	public Double observationValue;

	public Observation() {

	}

	public Observation(Long id, Area area, Indicator indicator,
			Measure measure, Time time, Organization provider) {
		super();
		this.id = id;
		this.area = area;
		this.indicator = indicator;
		this.measure = measure;
		this.time = time;
		this.provider = provider;
		this.observationValue = Double.parseDouble(this.measure.getMedida());
	}

	public Observation(Area area, Indicator indicator, Measure measure,
			Time time, Organization provider) {
		super();
		this.area = area;
		this.indicator = indicator;
		this.measure = measure;
		this.time = time;
		this.provider = provider;
		this.observationValue = Double.parseDouble(this.measure.getMedida());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Organization getProvider() {
		return provider;
	}

	public void setProvider(Organization provider) {
		this.provider = provider;
	}

	public static void create(Observation ob) {
		ob.save();
	}

	public static List<Observation> getAll() {
		return find.all();
	}

	public static List<Observation> getObservationsToCompare(Area area1,
			Area area2, Indicator indicator) {
		List<Observation> all = getAll();
		List<Observation> compared = new ArrayList<Observation>();

		for (Observation obs : all) {
			if ((obs.getArea().getId() == area1.getId())
					&& obs.getIndicator().getId().equals(indicator.getId())) {
				compared.add(obs);
				break;
			}
		}

		for (Observation obs : all) {
			if ((obs.getArea().getId() == area2.getId())
					&& obs.getIndicator().getId().equals(indicator.getId())) {
				compared.add(obs);
				break;
			}
		}

		if (compared.size() != 2) {
			throw new NoResultException(
					"No hemos encontrado datos para esa consulta :(");
		}

		return compared;
	}

	public Double getValue() {
		return observationValue;
	}

	public void setValue(Double value) {
		this.observationValue = value;
	}

	public static List<Observation> findByUser(User user) {
		
		List<Observation> orgObservation = new ArrayList<Observation>();

		for (Observation o : Observation.getAll()) {
			for (Pertenece p : user.getOrganizations()) {
				if (o.getProvider().getId() == p.getOrg().getId()) {
					orgObservation.add(o);
				}
			}
		}
		return orgObservation;
	}

	public static List<Observation> findByIndicator(Indicator indicator2) {
		List<Observation> obsByIndicator = new ArrayList<Observation>();
		
		for(Observation o : Observation.getAll()){
			if(o.getIndicator().getId().equals(indicator2.getId())){
				obsByIndicator.add(o);
			}
		}
		
		return obsByIndicator;
		
	}

	public String toString() {
		return "Org:"+this.provider+"|Value:"+this.observationValue.toString();
	}
	
	

}