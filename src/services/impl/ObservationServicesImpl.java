package services.impl;

import modelo.Observation;
import services.ObservationServices;
import services.impl.transactions.Observation.CRUDObservation;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class ObservationServicesImpl implements ObservationServices {

    @Override
    public void addObservation(Observation observation) throws SQLException {
        new CRUDObservation().add(observation);
    }

    @Override
    public void removeObservation(Observation observation) throws SQLException {
        new CRUDObservation().remove(observation);
    }

    @Override
    public List<Observation> getAll() throws SQLException {
        return new CRUDObservation().getAll();
    }

    @Override
    public Observation getByID(Integer id) throws SQLException {
        return new CRUDObservation().getByID(id);
    }
}
