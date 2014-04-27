package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Está clase permitirá acceder a la base de datos
 * 
 * @author LittleJ
 * 
 */
public class JdbcHelper {

	private static String DRIVER = "org.hsqldb.jdbcDriver";
	private static String URL = "jdbc:hsqldb:hsql://localhost";
	private static String USER = "sa";
	private static String PASS = "";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found in classpath", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	public static void cerrarConexion()
	{
		
	}

}
