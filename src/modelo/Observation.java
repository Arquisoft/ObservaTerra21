package modelo;

public class Observation {
	
	
	
	private int id;
	private Area area;
	private Indicator indicator;
	private Measure measure;
	private Time time;
	private Organization provider;

    public Observation(){

    }
	
	
	public Observation(int id, Area area, Indicator indicator, Measure measure,
			Time time, Organization provider) {
		super();
		this.id = id;
		this.area = area;
		this.indicator = indicator;
		this.measure = measure;
		this.time = time;
		this.provider = provider;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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
	

}
