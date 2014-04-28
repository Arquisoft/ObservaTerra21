package modelo;

import java.util.Date;

public class Time {
	
	private Date comienzo;
	private Date fin;
	
	public Time() {
	}
	
	/**
	 * Constructor utilizado cuando se quiere inicializar
	 * un instante de tiempo.
	 * 
	 * @param instante Fecha del instante en el que se hizo
	 * una observacion.
	 */
	public Time(Date instante) {
		super();
		//Se representa el instante haciendo que "comienzo"
		// y "fin" tengan el mismo valor.
		setComienzo(instante);
		setFin(instante);
	}
	
	/**
	 * Constructor utilizado cuando se quiere inicializar
	 * un lapso de tiempo.
	 * 
	 * @param comienzo Fecha de inicio del lapso de tiempo
	 * @param fin Fecha de fin del lapso de tiempo
	 */
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
