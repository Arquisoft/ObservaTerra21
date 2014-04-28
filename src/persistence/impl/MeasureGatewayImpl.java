package persistence.impl;

import modelo.Measure;
import persistence.JdbcHelper;
import persistence.MeasureGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeasureGatewayImpl implements MeasureGateway {

    @Override
    public void add(Measure measure) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO MEASURES(VALOR,UNIDAD) VALUES(?,?)");
        ps.setString(1, measure.getMedida());
        ps.setString(2, measure.getUnidad());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public void remove(Measure measure) throws SQLException {

        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM MEASURE WHERE ID = ?");
        ps.setInt(1, measure.getId());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    @Override
    public List<Measure> getAll() throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Measure> measures;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT  * FROM MEASURES");
        rs = ps.executeQuery();

        measures = new ArrayList<Measure>();

        while(rs.next()){
            Measure measure = new Measure();
            measure.setId(
                    rs.getInt("ID")
            );

            measure.setMedida(rs.getString("VALOR"));
            measure.setUnidad(rs.getString("UNIDAD"));

            measures.add(measure);
        }

        return measures;
    }

    @Override
    public Measure getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Measure measure = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT  * FROM MEASURES WHERE ID = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();


        while(rs.next()){
             measure = new Measure();
            measure.setId(
                    rs.getInt("ID")
            );

            measure.setMedida(rs.getString("VALOR"));
            measure.setUnidad(rs.getString("UNIDAD"));

        }

        return measure;
    }
}
