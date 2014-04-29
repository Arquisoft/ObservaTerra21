package services.impl;

import modelo.User;
import services.UserServices;
import services.impl.transactions.user.CRUDUser;

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
public class UserServicesImpl implements UserServices {

    @Override
    public void addUser(User user) throws SQLException {
        new CRUDUser().add(user);
    }

    @Override
    public void removeUser(User user) throws SQLException {
         new CRUDUser().remove(user);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return new CRUDUser().getAll();
    }

    @Override
    public User getUserByID(Integer id) throws SQLException {
        return new CRUDUser().getByID(id);
    }
}
