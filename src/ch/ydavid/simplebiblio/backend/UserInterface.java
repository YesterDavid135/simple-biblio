package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.User;

public interface UserInterface {
    public User addUser(User user);

    public void changeUser();

    public User searchUser(String username);
}
