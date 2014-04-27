package modelo;

import java.util.Date;
/**
 * Esta clase se utilizara para almacenar las subidas de ficheros de los usuarios
 * @author LittleJ
 *
 */
public class Upload {
	
	
	private int id;	
	private User user;
	private Date fecha;
	
	
	public Upload() {
	}

	public Upload(int id, User user, Date fecha) {
		this.id = id;
		this.user = user;
		this.fecha = fecha;
	}
	
	public Upload(User user, Date fecha) {
		this.user = user;
		this.fecha = fecha;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
