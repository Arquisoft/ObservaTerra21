package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;



@Entity
@Table(name="User")
public class User extends Model{

    public static Finder<Long,User> find =
            new Finder<Long,User>(Long.class, User.class);

    @Id
    @GeneratedValue
	private Integer id;

	private String usuario;

    private String password;

    private String mail;

    private String nombre;


	private String apellidos;

	@OneToMany(mappedBy="usuario")
	private List<Pertenece> organizations=  new ArrayList<Pertenece>();

	
	
    public  User(){
    }
    
   public void addOrganization(Organization org){
    	new Pertenece(this, org);

    }
   
   
	
	public User(int id, String usuario, String password, String mail,
			String nombre, String apellidos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.mail = mail;
		this.nombre = nombre;
		this.apellidos = apellidos;
		//this.organizacion = organizacion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

    /*


	public Organization getOrganizacion() {
		return organizacion;
	}


	public void setOrganizacion(Organization organizacion) {
		this.organizacion = organizacion;
	}


    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }


    


    public static User findById(String id){
        return find.where().eq("usuario", id).findUnique();
    }

    public static List<User> getAll(){
        return find.all();
    }

    public static void createUser(User user){
        user.save();
    }

	@Override
	public String toString() {
		return "User [id=" + id 
				+ ", usuario=" + usuario + ", password="
				+ password + ", mail=" + mail + ", nombre=" + nombre
				+ ", apellidos=" + apellidos +"]";
	}

	public List<Pertenece> getOrganizations() {
		return organizations;
	}
	
	public List<Organization> _getOrganizations() {
		List<Organization> orgs = new ArrayList<Organization>();
		for(Pertenece p : this.organizations){
			orgs.add(p.getOrg());
		}
		return orgs;
	}
	
	public List<Organization> _getNotMyOrganizations() {
		List<Organization> orgs = new ArrayList<Organization>();
		for(Pertenece p : this.organizations){
			orgs.add(p.getOrg());
		}
		
		List<Organization> all = Organization.getAll();
		List<Organization> notMy = new ArrayList<Organization>();

		for(Organization org : all){
			if(!orgs.contains(org)){
				notMy.add(org);
			}
		}
		return notMy;
	}

	public void setOrganizations(List<Pertenece> organizations) {
		this.organizations = organizations;
	}

	public void removeOrganization(Organization org) {
		Pertenece.delete(this, org);
		
	}

}
