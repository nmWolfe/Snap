package Card;

public class Card {

    private final CardSuit cardSuit;
    private final CardValues cardValue;

    public Card(CardSuit suit, CardValues value){
        this.cardSuit = suit;
        this.cardValue = value;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public int getCardValue() {
        return cardValue.getCardNumValue();
    }

    @Override
    public String toString(){
        return "[" + cardSuit.getCardType() + cardValue.getCardStrValue() + " ]";
    }
}
