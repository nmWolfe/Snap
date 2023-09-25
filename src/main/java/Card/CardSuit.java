package Card;

public enum CardSuit {
    DIAMONDS("\u001B[31m ♢ \u001B[0m"),
    CLUBS("\u001B[30m ♧ \u001B[0m"),
    HEARTS("\u001B[31m ♡ \u001B[0m"),
    SPADES( "\u001B[30m ♤ \u001B[0m");

    private final String uniVal;

    CardSuit(String uniVal){
        this.uniVal = uniVal;
    }

    public String getCardType(){
        return uniVal;
    }
}
