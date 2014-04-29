package services.impl;

import modelo.Area;
import services.AreaServices;
import services.impl.transactions.Area.CRUDArea;

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
public class AreaServiceImpl implements AreaServices {

    @Override
    public void add(Area area) throws SQLException {
        new CRUDArea().add(area);
    }

    @Override
    public void remove(Area area) throws SQLException {
        new CRUDArea().remove(area);
    }

    @Override
    public List<Area> getAll() throws SQLException {
        return new CRUDArea().getAll();
    }

    @Override
    public Area getByID(Integer id) throws SQLException {
        return new CRUDArea().getByID(id);
    }
}
