package persistence.impl;

import modelo.Area;
import persistence.AreaGateway;
import persistence.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaGatewayImpl implements AreaGateway {

    @Override
    public void add(Area area) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO AREAS(NOMBRE) VALUES(?)");
        ps.setString(1,area.getNombre());
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public void remove(Area area) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM AREAS WHERE ID = ?");
        ps.setInt(1,area.getId());
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public List<Area> getAll() throws SQLException {
       Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Area> areas;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM AREAS ");
        rs = ps.executeQuery();

        areas = new ArrayList<Area>();

        while(rs.next()){
            Area area = new Area();
            area.setId(rs.getInt("ID"));
            area.setNombre(rs.getString("NOMBRE"));
            area.setAreas(getSubAreas(area));

            areas.add(area);
        }


        return areas;
    }

    @Override
    public Area getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Area area = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM AREAS WHERE ID = ? ");
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while(rs.next()){
            area = new Area();
            area.setId(rs.getInt("ID"));
            area.setNombre(rs.getString("NOMBRE"));
            area.setAreas(getSubAreas(area));

        }


        return area;
    }

    private List<Area> getSubAreas(Area area){
        // TODO
        return null;
    }
}
