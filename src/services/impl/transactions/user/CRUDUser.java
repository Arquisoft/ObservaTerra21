package services.impl.transactions.user;

import factories.Factories;
import modelo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Project: ObservaTerra21
 * Package: services.impl.transactions.user
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class CRUDUser {

    public CRUDUser(){

    }

    public void add(User user) throws SQLException {
        Factories.getPersistenceFactory().getUserGateway().add(user);
    }

    public void remove(User user) throws SQLException {
        Factories.getPersistenceFactory().getUserGateway().remove(user);
    }

    public List<User> getAll() throws SQLException {
        return Factories.getPersistenceFactory().getUserGateway().getAll();
    }

    public User getByID(Integer id) throws SQLException {
        return Factories.getPersistenceFactory().getUserGateway().getByID(id);
    }
}
