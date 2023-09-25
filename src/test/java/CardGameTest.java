import Card.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {

    private CardGame game;

    @BeforeEach
    void setUp(){
        game = new NologySnap("testGame");
    }

    @Test
    void deal_DealSingleCard_ReturnOneCard(){
        Card singleCard = game.dealCard();
        assertNotNull(singleCard);
    }

    @Test
    void deal_DealTwoSingleCards_CardsAreDifferent(){
        Card singleCard = game.dealCard();
        Card otherSingleCard = game.dealCard();
        assertNotNull(singleCard);
        assertNotNull(otherSingleCard);
        assertNotSame(singleCard, otherSingleCard);
    }

    @Test
    void sort_SortDeckOfCards_SortedBySuit() {
    }

    @Test
    void sort_SortDeckOfCards_SortedByValue() {
    }

    @Test
    void shuffleDeck_ShuffleDeckMethod_FirstDeckDifferentThanSecond() {
        //
        List<Card> deckOne = new ArrayList<>(game.getDeckOfCards());
        game.shuffleDeck();
        List<Card> deckTwo = game.getDeckOfCards();
        assertNotSame(deckOne.get(0), deckTwo.get(0));
        assertNotEquals(deckOne.get(0), deckTwo.get(0));

    }
}