package persistence.impl;

import modelo.Time;
import persistence.JdbcHelper;
import persistence.TimeGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeGatewayImpl implements TimeGateway{

    @Override
    public void add(Time time) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("INSERT INTO TIMES(FECHA_INICIO,FECHA_FIN) VALUES(?,?)");
        ps.setDate(1, (java.sql.Date) time.getComienzo());
        ps.setDate(2, (java.sql.Date) time.getFin());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public void remove(Time time) throws SQLException {
        Connection con;
        PreparedStatement ps;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("DELETE FROM TIMES WHERE ID = ?");
        ps.setInt(1, time.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    @Override
    public List<Time> getAll() throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Time> times;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM TIMES");
        rs = ps.executeQuery();

        times = new ArrayList<Time>();

        while(rs.next()){
            Time time = new Time();
            time.setComienzo(rs.getDate("FECHA_INICIO"));
            time.setFin(rs.getDate("FECHA_FIN"));
            time.setId(rs.getInt("ID"));

            times.add(time);
        }

        return times;
    }

    @Override
    public Time getByID(Integer id) throws SQLException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Time time = null;

        con = JdbcHelper.getConnection();
        ps = con.prepareStatement("SELECT * FROM TIMES WHERE ID = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();


        while(rs.next()){
            time = new Time();
            time.setComienzo(rs.getDate("FECHA_INICIO"));
            time.setFin(rs.getDate("FECHA_FIN"));
            time.setId(rs.getInt("ID"));

        }

        return time;
    }
}
