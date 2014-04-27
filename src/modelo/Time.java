package modelo;

import java.util.Date;

public class Time {
	
	
	private Date comienzo;
	private Date fin;
	
	
	
	public Time() {
	}
	public Time(Date comienzo, Date fin) {
		super();
		this.comienzo = comienzo;
		this.fin = fin;
	}
	public Date getComienzo() {
		return comienzo;
	}
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	
	

}
