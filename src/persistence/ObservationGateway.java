package persistence;

import modelo.Observation;

import java.sql.SQLException;
import java.util.List;

public interface ObservationGateway {

    public void add(Observation observation) throws SQLException;
    public void remove(Observation observation) throws SQLException;
    public List<Observation> getAll() throws SQLException;
    public Observation getByID(Integer id) throws SQLException;

}
