package persistence.impl;


import modelo.Observation;
import persistence.JdbcHelper;
import persistence.ObservationGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ObservationGatewayImpl implements ObservationGateway {

    @Override
    public void add(Observation observation) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO OBSERVATIONS(ID_AREA,ID_INDICATOR,ID_MEASURE,ID_TIME, ID_PROVIDER) VALUES(?,?,?,?,?)");
        ps.setInt(1, observation.getArea().getId());
        ps.setInt(2, observation.getIndicator().getId());
        ps.setInt(3, observation.getMeasure().getId());
        ps.setInt(4, observation.getTime().getId());
        ps.setInt(5, observation.getProvider().getId());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    @Override
    public void remove(Observation observation) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM OBSERVATIONS WHERE ID = ?");
        ps.setInt(1, observation.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public List<Observation> getAll() throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Observation> observations;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM OBSERVATIONS");
        rs = ps.executeQuery();

        observations = new ArrayList<Observation>();

        while (rs.next()) {
            Observation observation = new Observation();
            observation.setArea(new AreaGatewayImpl().getByID(rs.getInt("ID_AREA")));
            observation.setIndicator(new IndicatorGatewayImpl().getByID(rs.getInt("ID_INDICATOR")));
            observation.setMeasure(new MeasureGatewayImpl().getByID(rs.getInt("ID_MEASURE")));
            observation.setTime(new TimeGatewayImpl().getByID(rs.getInt("ID_TIME")));
            observation.setProvider(new OrganizationGatewayImpl().getByID(rs.getInt("ID_PROVIDER")));

            observations.add(observation);
        }

        return observations;


    }

    @Override
    public Observation getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Observation observation = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM OBSERVATIONS WHERE ID = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();


        while (rs.next()) {
            observation = new Observation();
            observation.setArea(new AreaGatewayImpl().getByID(rs.getInt("ID_AREA")));
            observation.setIndicator(new IndicatorGatewayImpl().getByID(rs.getInt("ID_INDICATOR")));
            observation.setMeasure(new MeasureGatewayImpl().getByID(rs.getInt("ID_MEASURE")));
            observation.setTime(new TimeGatewayImpl().getByID(rs.getInt("ID_TIME")));
            observation.setProvider(new OrganizationGatewayImpl().getByID(rs.getInt("ID_PROVIDER")));
        }

        return observation;

    }

}
