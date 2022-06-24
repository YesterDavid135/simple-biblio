package ch.ydavid.simplebiblio.sqlHandler;

import ch.ydavid.simplebiblio.dto.Location;
import ch.ydavid.simplebiblio.dto.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserHandler extends SqlHandler {

    /**
     * Creates a new User
     *
     * @param user User to be Created
     */
    public void addUser(User user) {

        String query = "SELECT * FROM tbl_location WHERE \"ZIP\"= '" + user.getLocation().getZIP() + "'";

        try {
            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Location> locations = new ArrayList<>();

            while (rs.next()) {
                Location location = new Location();
                location.setLocation(rs.getString("location"));
                location.setIdLoc(rs.getInt("IdLoc"));
                locations.add(location);

            }

            if (locations.size() == 0) {
                throw new Exception("ZIP is wrong.");
            }

            if (locations.size() == 1) {
                user.setLocation(locations.get(0));
            }

            if (locations.size() > 1) {
                for (Location location : locations) {
                    if (location.getLocation().equals(user.getLocation().getLocation())) {
                        user.setLocation(location);
                        break;
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        }

        query = "INSERT INTO tbl_users (name,vname,yob,street,fk_location,mail,password,username) VALUES ('" + user.getName() + "','" + user.getVname() + "'," + user.getYob() + ",'" + user.getStreet() + "'," + user.getLocation().getIdLoc() + ",'" + user.getMail() + "','" + user.getPassword() + "','" + user.getUsername() + "');";

        try {
            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            stmt.execute(query);


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Removes a User <br>
     *
     * @param username user to be changed
     */
    public boolean removeUser(String username) {


        String query = "delete from tbl_users where username = \'" + username + "\'";

        try {
            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            if (!stmt.execute(query)) {
                int count = stmt.getUpdateCount();
                return count == 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Search for a User
     *
     * @param username username to be searched for
     * @return User Object or null if not found
     */
    public User searchUser(String username) {

        String query = "SELECT * FROM tbl_users left join tbl_location as l on tbl_users.fk_location = l.\"idLoc\" where username = \'" + username + "\' limit 1";

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
                        new Location(
                                rs.getInt("idLoc"),
                                rs.getString("ZIP"),
                                rs.getString("location")
                        ),
                        rs.getInt("idUser"),
                        rs.getString("mail"),
                        rs.getString("username"),
                        rs.getInt("password") // very secure
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean changePassword(User user) {

        String query = "UPDATE tbl_users SET password = '" + user.getPassword() + "' WHERE username = '" + user.getUsername() + "'";

        try {
            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            if (!stmt.execute(query)) {
                int count = stmt.getUpdateCount();
                return count == 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
