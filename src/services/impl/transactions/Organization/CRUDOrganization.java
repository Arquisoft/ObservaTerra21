package services.impl.transactions.Organization;

import factories.Factories;
import modelo.Organization;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.Organization
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDOrganization {

    public void add(Organization organization) throws SQLException {
        Factories.getPersistenceFactory().getOrganizationGateway().add(organization);
    }

    public void remove(Organization organization) throws SQLException {
        Factories.getPersistenceFactory().getOrganizationGateway().remove(organization);
    }

    public List<Organization> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getOrganizationGateway().getAll();
    }

    public Organization getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getOrganizationGateway().getByID(id);
    }
}
