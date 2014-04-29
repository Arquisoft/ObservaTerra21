package services;

import modelo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Defines the user's services
 */
public interface UserServices {


    /**
     * Adds a user to the database
     * @param user user to store in the system
     */
    public void addUser(User user) throws SQLException;

    /**
     * Deletes a user to the system
     * @param user user to be deleted
     */
    public void removeUser(User user) throws SQLException;

    /**
     * Retrieves all users existent in the database
     * @return A list of users stored in the database
     */
    public List<User> getAllUsers() throws SQLException;

    /**
     * Returns a user by their ID
     * @param id user's ID
     * @return Selected user
     */
    public User getUserByID(Integer id) throws SQLException;

}
