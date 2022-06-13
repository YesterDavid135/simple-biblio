package ch.ydavid.simplebiblio.sqlHandler;

import ch.ydavid.simplebiblio.dto.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserHandler extends SqlHandler {

    /**
     * Creates a new User
     *
     * @param user User to be Created
     */
    public void addUser(User user) {


    }

    /**
     * Changes a User <br>
     * Everything can be changed except the ID
     *
     * @param user user to be changed
     */
    public void changeUser(User user) {

    }

    /**
     * Search for a User
     *
     * @param username username to be searched for
     * @return User Object or null if not found
     */
    public User searchUser(String username) {

        String query = "SELECT * FROM tbl_users where username = \"" + username + "\" limit 1";

        try {
            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getString("vname"),
                        rs.getInt("yob"),
                        rs.getString("street"),
                        null, // to lazy for that todo @noel
                        rs.getInt("idUser"),
                        rs.getString("username"),
                        rs.getInt("password") // very secure
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
