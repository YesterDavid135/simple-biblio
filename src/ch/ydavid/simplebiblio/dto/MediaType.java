package ch.ydavid.simplebiblio.dto;


public enum MediaType {
    Book(), Audio_CD(), DVD(), ComputerGames();

    MediaType() {
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