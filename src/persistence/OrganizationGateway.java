package persistence;

import modelo.Organization;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationGateway {

    public void add(Organization organization) throws SQLException;
    public void remove(Organization organization) throws SQLException;
    public List<Organization> getAll() throws SQLException;
    public Organization getByID(Integer id) throws SQLException;

}
