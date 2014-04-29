package services.impl.transactions.Time;

import factories.Factories;
import modelo.Time;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Time
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDTime {

    public void add(Time time) throws SQLException {
        Factories.getPersistenceFactory().getTimeGateway().add(time);
    }

    public void remove(Time time) throws SQLException {
        Factories.getPersistenceFactory().getTimeGateway().remove(time);
    }

    public List<Time> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getTimeGateway().getAll();
    }

    public Time getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getTimeGateway().getByID(id);
    }
}
