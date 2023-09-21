
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardGame {
    private final List<Card> deckOfCards;
    private String name;

    public CardGame(String name){
        this.name = name;
        this.deckOfCards = new CardDeck().getDeck();
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void displayDeck(){
        for (Card card: deckOfCards) {
            System.out.println(card);
        }
    }


    public void sortDeck(CardSorting cardSorting){
        switch (cardSorting) {
            case BY_SUIT:
                Collections.sort(deckOfCards, Comparator.comparing(Card::getCardSuit));
                break;
            case BY_VALUE:
                Collections.sort(deckOfCards, Comparator.comparingInt(Card::getCardValue));
                break;
        }
    }
}
