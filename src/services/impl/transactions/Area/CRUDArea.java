package services.impl.transactions.Area;

import factories.Factories;
import modelo.Area;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Area
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDArea {

    public void add(Area area) throws SQLException {
        Factories.getPersistenceFactory().getAreaGateway().add(area);
    }

    public void remove(Area area) throws SQLException {
        Factories.getPersistenceFactory().getAreaGateway().remove(area);
    }

    public List<Area> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getAreaGateway().getAll();
    }

    public Area getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getAreaGateway().getByID(id);
    }
}
