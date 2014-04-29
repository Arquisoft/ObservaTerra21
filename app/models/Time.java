package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.ebean.Model;
@Entity
public class Time extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date comienzo;
	private Date fin;
    private Integer id;
	
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

	@Override
	public String toString() {
		return "Time [comienzo=" + comienzo + ", fin=" + fin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comienzo == null) ? 0 : comienzo.hashCode());
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (comienzo == null) {
			if (other.comienzo != null)
				return false;
		} else if (!comienzo.equals(other.comienzo))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		return true;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
