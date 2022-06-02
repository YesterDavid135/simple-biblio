package dto;

public class User {

    private int idUser;
    private String name;
    private String vname;
    private int yob; //year of birth
    private String street;
    private Location location;
    private String mail;

    public User(int idUser, String name, String vname, int yob, String street, Location location, String mail) {
        this.idUser = idUser;
        this.name = name;
        this.vname = vname;
        this.yob = yob;
        this.street = street;
        this.location = location;
        this.mail = mail;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
