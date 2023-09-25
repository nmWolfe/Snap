import Card.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    private CardDeck deck;

    @BeforeEach
    void setUp() {
        deck = new CardDeck();
    }

    @Test
    void get_CardDeck_ReturnListOfCards() {
        List<Card> cardDeck = deck.getDeck();
        assertNotNull(cardDeck);
        assertEquals(52, cardDeck.size());
    }
}