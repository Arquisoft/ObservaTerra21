package persistence;

import modelo.Time;

import java.sql.SQLException;
import java.util.List;

public interface TimeGateway {

    public void add(Time time) throws SQLException;
    public void remove(Time time) throws SQLException;
    public List<Time> getAll() throws SQLException;
    public Time getByID(Integer id) throws SQLException;


}
