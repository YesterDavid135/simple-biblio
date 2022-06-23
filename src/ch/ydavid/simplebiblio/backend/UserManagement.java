package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.User;
import ch.ydavid.simplebiblio.sqlHandler.UserHandler;

public class UserManagement implements UserInterface {
    UserHandler sqlHandler = new UserHandler();

    /**
     * Add a User to the database
     *
     * @return
     */
    public User addUser(User user) {
        sqlHandler.addUser(user);
        return sqlHandler.searchUser(user.getUsername());
    }

    public boolean checkUsername(String username){
        return sqlHandler.searchUser(username) == null;
    }

    /**
     * Remove a User in the Database
     */
    public boolean removeUser(String username) {
        return sqlHandler.removeUser(searchUser(username));
    }

    /**
     * Search for a User in the Database
     */
    public User searchUser(String username) {
        return sqlHandler.searchUser(username);
    }

    /**
     * Check if Username and password matches
     *
     * @param username username to check
     * @param password password to check
     * @return User if login is successful else null
     */
    public User checkLogin(String username, String password) {

        User user = sqlHandler.searchUser(username);

        if (user != null && user.getPassword() == password.hashCode()) {
            user.setPassword(69); //Very secure
            return user;
        }

        return null;
    }
}
