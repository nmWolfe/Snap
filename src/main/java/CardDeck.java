import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final List<Card> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValues value : CardValues.values()) {
                deck.add(new Card(suit, value));
            }

        }
    }

    public List<Card> getDeck(){
        return deck;
    }

}
