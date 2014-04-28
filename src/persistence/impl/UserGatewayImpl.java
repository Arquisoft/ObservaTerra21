package persistence.impl;

import modelo.User;
import persistence.JdbcHelper;
import persistence.UserGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGatewayImpl implements UserGateway {


    @Override
    public void add(User user) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO USUARIOS(USUARIO, PASSWORD, NOMBRE, APELLIDOS, EMAIL, ID_ORGANIZACION) VALUES(?,?,?,?,?,?)");
        ps.setString(1, user.getUsuario());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getNombre());
        ps.setString(4, user.getApellidos());
        ps.setString(5, user.getMail());
        ps.setInt(6, user.getOrganizacion().getId());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    @Override
    public void remove(User user) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM USUARIOS WHERE ID = ?");
        ps.setInt(1, user.getId());
        ps.executeUpdate();

        ps.close();
        con.close();

    }

    @Override
    public List<User> getAll() throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<User> usuarios;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM USUARIOS");
        rs = ps.executeQuery();

        usuarios = new ArrayList<User>();

        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("ID"));
            user.setNombre(rs.getString("NOMBRE"));
            user.setApellidos(rs.getString("APELIIDOS"));
            user.setMail(rs.getString("EMAIL"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setUsuario(rs.getString("USUARIO"));
            user.setOrganizacion(new OrganizationGatewayImpl().getByID(rs.getInt("ID_ORGANIZACION")));

            usuarios.add(user);
        }

        return usuarios;
    }

    @Override
    public User getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        User user = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM USUARIOS WHERE ID = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();



        while(rs.next()){
            user = new User();
            user.setId(rs.getInt("ID"));
            user.setNombre(rs.getString("NOMBRE"));
            user.setApellidos(rs.getString("APELIIDOS"));
            user.setMail(rs.getString("EMAIL"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setUsuario(rs.getString("USUARIO"));
            user.setOrganizacion(new OrganizationGatewayImpl().getByID(rs.getInt("ID_ORGANIZACION")));

        }

        return user;
    }
}
