import Card.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

abstract class CardGame {
    protected List<Card> deckOfCards;
    protected String name;
    protected final Random rand;

    public CardGame(String name){
        this.name = name;
        this.deckOfCards = new CardDeck().getDeck();
        this.rand = new Random();
    }

    public List<Card> getDeckOfCards() {
        deckOfCards = new CardDeck().getDeck();
        return deckOfCards;
    }

    public void displayDeck(){
        for (Card card: deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard(){
        return deckOfCards.remove(rand.nextInt(deckOfCards.size()));
    }

    public void sortDeck(CardSorting cardSorting){
        switch (cardSorting) {
            case BY_SUIT:
                deckOfCards.sort(Comparator.comparing(Card::getCardSuit));
                break;
            case BY_VALUE:
                deckOfCards.sort(Comparator.comparingInt(Card::getCardValue));
                break;
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deckOfCards);
    }
}
