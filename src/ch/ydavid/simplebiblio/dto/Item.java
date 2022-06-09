package ch.ydavid.simplebiblio.dto;


public class Item {

	private int ID;
    private String Titel;
    private MediaType mediaType;
	private int ageRating;
	private String autor;
	private int isbn;
	private int shelf;

    public Item(int ID, String titel, MediaType mediaType, int ageRating, String autor, int isbn, int shelf) {
        this.ID = ID;
        Titel = titel;
        this.mediaType = mediaType;
        this.ageRating = ageRating;
        this.autor = autor;
        this.isbn = isbn;
        this.shelf = shelf;
    }

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
}