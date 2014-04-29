package services.impl.transactions.Indicator;

import factories.Factories;
import modelo.Indicator;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Indicator
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDIndicator {

    public void add(Indicator indicator) throws SQLException {
        Factories.getPersistenceFactory().getIndicatorGateway().add(indicator);
    }

    public void remove(Indicator indicator) throws SQLException {
        Factories.getPersistenceFactory().getIndicatorGateway().remove(indicator);
    }


    public List<Indicator> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getIndicatorGateway().getAll();
    }


    public Indicator  getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getIndicatorGateway().getByID(id);
    }
}
