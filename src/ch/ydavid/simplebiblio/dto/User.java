package ch.ydavid.simplebiblio.dto;


public class User {

	private String name;
	private String vname;
	private int yob;
	private String street;
	private Location location;
	private int idUser;

	private String username;
	private int password;


	public User(String name, String vname, int yob, String street, Location location, int idUser, String username, int password) {
		this.name = name;
		this.vname = vname;
		this.yob = yob;
		this.street = street;
		this.location = location;
		this.idUser = idUser;
		this.username = username;
		this.password = password;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}