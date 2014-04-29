package services.impl.transactions.Measure;

import factories.Factories;
import modelo.Measure;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Measure
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDMeasure {

    public void add(Measure measure) throws SQLException {
        Factories.getPersistenceFactory().getMeasureGateway().add(measure);
    }

    public void remove(Measure measure) throws SQLException {
        Factories.getPersistenceFactory().getMeasureGateway().remove(measure);
    }

    public List<Measure> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getMeasureGateway().getAll();
    }

    public Measure getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getMeasureGateway().getByID(id);
    }
}
