package persistence.impl;

import modelo.Organization;
import persistence.JdbcHelper;
import persistence.OrganizationGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationGatewayImpl implements OrganizationGateway {

    @Override
    public void add(Organization organization) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO ORGANIZATION(NOMBRE) VALUES (?)");
        ps.setString(1, organization.getNombre());
        ps.executeUpdate();

        ps.close();
        con.close();

    }

    @Override
    public void remove(Organization organization) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM ORGANIZATION WHERE ID = ?");
        ps.setInt(1, organization.getId());
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public List<Organization> getAll() throws SQLException {
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       List<Organization> organizations;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM ORGANIZATION");
        rs = ps.executeQuery();

        organizations = new ArrayList<Organization>();

        while(rs.next()){
            Organization organization = new Organization();
            organization.setId(rs.getInt("ID"));
            organization.setNombre(rs.getString("NOMBRE"));

            organizations.add(organization);
        }

        return organizations;
    }

    @Override
    public Organization getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Organization organization = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM ORGANIZATION WHERE ID = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while(rs.next()){
             organization = new Organization();
            organization.setId(rs.getInt("ID"));
            organization.setNombre(rs.getString("NOMBRE"));
        }

        return organization;
    }
}
