package dto;

public class Inventory {

    private int idMedia;
    private String title;
    private int ageRating;
    private String autor;
    private String ISBN;
    private String shelf;
    private MediaType genre;

    public Inventory(int idMedia, String title, int ageRating, String autor, String ISBN, String shelf, MediaType genre) {
        this.idMedia = idMedia;
        this.title = title;
        this.ageRating = ageRating;
        this.autor = autor;
        this.ISBN = ISBN;
        this.shelf = shelf;
        this.genre = genre;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public MediaType getGenre() {
        return genre;
    }

    public void setGenre(MediaType genre) {
        this.genre = genre;
    }
}
