package ch.ydavid.simplebiblio.dto;


public class Location {

	private int idLoc;
	private String ZIP;
	private String location;

	public Location(int idLoc, String ZIP, String location) {
		this.idLoc = idLoc;
		this.ZIP = ZIP;
		this.location = location;
	}

	public Location() {

	}

	public int getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(int idLoc) {
		this.idLoc = idLoc;
	}

	public String getZIP() {
		return ZIP;
	}

	public void setZIP(String ZIP) {
		this.ZIP = ZIP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}