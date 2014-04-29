package services;

import modelo.Indicator;
import modelo.Measure;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by noe on 29/04/2014.
 */
public interface  IndicatorServices {

    public void add(Indicator indicator) throws SQLException;
    public void remove(Indicator indicator) throws SQLException;
    public List<Indicator> getAll() throws SQLException;
    public Indicator getByID(Integer id) throws SQLException;
}
