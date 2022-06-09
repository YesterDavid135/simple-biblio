package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.User;
import ch.ydavid.simplebiblio.sqlHandler.UserHandler;

public class UserManagement implements UserInterface {

    UserHandler sqlHandler = new UserHandler();

    /**
     * Add a User to the database
     */
    public void addUser() {

    }

    /**
     * Change a User in the Database
     */
    public void changeUser() {

    }

    /**
     * Search for a User in the Database
     */
    public void searchUser() {

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
