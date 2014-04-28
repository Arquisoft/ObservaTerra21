package persistence;

import modelo.Measure;

import java.sql.SQLException;
import java.util.List;

public interface MeasureGateway {

    public void add(Measure measure) throws SQLException;

    public void remove(Measure measure) throws SQLException;

    public List<Measure> getAll() throws SQLException;

    public Measure getByID(Integer id) throws SQLException;

}
