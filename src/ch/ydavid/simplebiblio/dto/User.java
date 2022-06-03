package ch.ydavid.simplebiblio.dto;


public class User {

	private String name;
	private String vname;
	private int yob;
	private String street;
	private Location location;
	private int idUser;

	public User(String name, String vname, int yob, String street, Location location, int idUser) {
		this.name = name;
		this.vname = vname;
		this.yob = yob;
		this.street = street;
		this.location = location;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}