package services.impl;

import modelo.Time;
import services.TimeServices;
import services.impl.transactions.Time.CRUDTime;

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
public class TimeServicesImpl implements TimeServices{
    @Override
    public void addTime(Time time) throws SQLException {
        new CRUDTime().add(time);
    }

    @Override
    public void removeTime(Time time) throws SQLException {
        new CRUDTime().remove(time);
    }

    @Override
    public List<Time> getAllTimeIntevals() throws SQLException {
        return  new CRUDTime().getAll();
    }

    @Override
    public Time getByID(Integer id) throws SQLException {
        return new CRUDTime().getByID(id);
    }
}
