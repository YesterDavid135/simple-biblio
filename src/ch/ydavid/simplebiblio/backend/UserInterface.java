package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.User;

public interface UserInterface {
    public void addUser(User user);

    public void changeUser();

    public void searchUser();
}
