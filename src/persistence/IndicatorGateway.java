package persistence;

import modelo.Country;
import modelo.Indicator;

import java.sql.SQLException;
import java.util.List;

public interface IndicatorGateway {

    public void add(Indicator indicator) throws SQLException;
    public void remove(Indicator indicator) throws SQLException;
    public List<Indicator> getAll() throws SQLException;
    public Indicator getByID(Integer id) throws SQLException;

}
