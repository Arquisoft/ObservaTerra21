package persistence;

import modelo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserGateway {

    public void add(User user) throws SQLException;
    public void remove(User user) throws SQLException;
    public List<User> getAll() throws SQLException;
    public User getByID(Integer id) throws SQLException;

}
