package ch.ydavid.simplebiblio.dto;


public enum MediaType {
    Book(1), Audio_CD(2), DVD(3), ComputerGames(4);

    MediaType(int i) {
    }

    public MediaType getValue(int i) {
        return switch (i) {
            case 1 -> Book;
            case 2 -> Audio_CD;
            case 3 -> DVD;
            case 4 -> ComputerGames;
            default -> null;
        };
    }

}