package services.impl;

import modelo.Measure;
import persistence.MeasureGateway;
import services.MeasureServices;
import services.impl.transactions.Measure.CRUDMeasure;

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
public class MeasureServicesImpl implements MeasureServices{
    @Override
    public void add(Measure measure) throws SQLException {
        new CRUDMeasure().add(measure);
    }

    @Override
    public void remove(Measure measure) throws SQLException {
        new CRUDMeasure().remove(measure);
    }

    @Override
    public List<Measure> getAll() throws SQLException {
        return new CRUDMeasure().getAll();
    }

    @Override
    public Measure getByID(Integer id) throws SQLException {
        return new CRUDMeasure().getByID(id);
    }
}
