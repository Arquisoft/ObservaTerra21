package services.impl;

import modelo.Organization;
import services.OrganizationServices;
import services.impl.transactions.Organization.CRUDOrganization;

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
public class OrganizationServicesImpl implements OrganizationServices{

    @Override
    public void addOrganization(Organization organization) throws SQLException {
        new CRUDOrganization().add(organization);
    }

    @Override
    public void removeOrganization(Organization organization) throws SQLException {
        new CRUDOrganization().remove(organization);
    }

    @Override
    public Organization getByID(Integer id) throws SQLException {

        return new CRUDOrganization().getByID(id);
    }

    @Override
    public List<Organization> getAll() throws SQLException {

        return new CRUDOrganization().getAll();
    }
}
