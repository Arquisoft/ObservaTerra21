package services;

import modelo.Measure;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by noe on 29/04/2014.
 */
public interface MeasureServices {

    public void add(Measure measure) throws SQLException;
    public void remove(Measure measure) throws SQLException;
    public List<Measure> getAll() throws SQLException;
    public Measure getByID(Integer id) throws SQLException;
}
