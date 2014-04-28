package persistence;

import modelo.Area;

import java.sql.SQLException;
import java.util.List;

public interface AreaGateway {

    public void add(Area area) throws SQLException;
    public void remove(Area area) throws SQLException;
    public List<Area> getAll() throws SQLException;
    public Area getByID(Integer id) throws SQLException;

}
