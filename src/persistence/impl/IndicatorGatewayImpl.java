package persistence.impl;

import modelo.Indicator;
import persistence.IndicatorGateway;
import persistence.JdbcHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndicatorGatewayImpl implements IndicatorGateway{

    @Override
    public void add(Indicator indicator) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO INDICATORS(NOMBRE) VALUES(?) ");
        ps.setString(1,indicator.getIndicador());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public void remove(Indicator indicator) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM INDICATORS WHERE ID = ? ");
        ps.setInt(1, indicator.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public List<Indicator> getAll() throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Indicator> indicators;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM INDICATORS");
        rs = ps.executeQuery();

        indicators = new ArrayList<Indicator>();

        while(rs.next()){
            Indicator indicator = new Indicator();
            indicator.setId(rs.getInt("ID"));
            indicator.setIndicador(rs.getString("NOMBRE"));
            indicators.add(indicator);
        }

        return indicators;
    }

    @Override
    public Indicator getByID(Integer id) throws SQLException {

        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Indicator indicator = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM INDICATORS WHERE ID = ?");
        ps.setInt(1,id);

        rs = ps.executeQuery();

        while(rs.next()){
            indicator = new Indicator();
            indicator.setId(rs.getInt("ID"));
            indicator.setIndicador(rs.getString("NOMBRE"));
        }

        return indicator;

    }
}
