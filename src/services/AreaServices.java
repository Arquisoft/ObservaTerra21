package services;

import modelo.Area;
import modelo.Measure;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by noe on 29/04/2014.
 */
public interface AreaServices {

    public void add(Area area) throws SQLException;
    public void remove(Area area) throws SQLException;
    public List<Area> getAll() throws SQLException;
    public Area getByID(Integer id) throws SQLException;
}
