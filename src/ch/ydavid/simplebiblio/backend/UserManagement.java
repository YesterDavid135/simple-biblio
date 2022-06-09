package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.User;
import ch.ydavid.simplebiblio.sqlHandler.UserHandler;

public class UserManagement implements UserInterface {

    UserHandler sqlHandler = new UserHandler();

    public void addUser() {

    }

    public void changeUser() {

    }

    public void searchUser() {

    }

    public User checkLogin(String username, String password) {

        User user = sqlHandler.searchUser(username);

        if (user != null && user.getPassword() == password.hashCode()) {
            user.setPassword(69); //Very secure
            return user;
        }

        return null;
    }
}
