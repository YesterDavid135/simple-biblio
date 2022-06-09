package ch.ydavid.simplebiblio.dto;


public enum MediaType {
    Book(1), Audio_CD(2), DVD(3), ComputerGames(4);

    MediaType(int i) {
    }

    public MediaType getValue(int i) {
        switch (i) {
            case 1:
                return Book;
            case 2:
                return Audio_CD;
            case 3:
                return DVD;
            case 4:
                return ComputerGames;
            default:
                return null;
        }
    }
}