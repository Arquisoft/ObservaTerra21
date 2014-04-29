package services;

import modelo.Observation;

import java.sql.SQLException;
import java.util.List;

/**
 * Defines the operations over the observations
 */
public interface ObservationServices {


    public void addObservation(Observation observation) throws SQLException;
    public void removeObservation(Observation observation) throws SQLException;
    public List<Observation> getAll() throws SQLException;
    public Observation getByID(Integer id) throws SQLException;
}
