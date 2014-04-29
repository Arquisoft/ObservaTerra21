package services.impl.transactions.Observation;

import factories.Factories;
import modelo.Observation;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Observation
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDObservation {

    public void add(Observation observation) throws SQLException {
        Factories.getPersistenceFactory().getObservationGateway().add(observation);
    }

    public void remove(Observation observation) throws SQLException {
        Factories.getPersistenceFactory().getObservationGateway().remove(observation);
    }


    public List<Observation> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getObservationGateway().getAll();
    }

    public Observation getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getObservationGateway().getByID(id);
    }
}
