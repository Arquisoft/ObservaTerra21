package services.impl;

import modelo.Indicator;
import services.IndicatorServices;
import services.impl.transactions.Indicator.CRUDIndicator;

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
public class IndicatorServicesImpl implements IndicatorServices {
    @Override
    public void add(Indicator indicator) throws SQLException {
        new CRUDIndicator().add(indicator);
    }

    @Override
    public void remove(Indicator indicator) throws SQLException {
        new CRUDIndicator().remove(indicator);
    }

    @Override
    public List<Indicator> getAll() throws SQLException {
        return new CRUDIndicator().getAll();
    }

    @Override
    public Indicator getByID(Integer id) throws SQLException {
        return new CRUDIndicator().getByID(id);
    }
}
