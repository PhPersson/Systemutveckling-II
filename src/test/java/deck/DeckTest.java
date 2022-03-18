package deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {
        Deck d = new Deck();
        d.shuffle();
    }

    @Test
    void getCard() {
        Deck d = new Deck();
        d.shuffle();
        assertEquals(d.getDeck().get(0), d.getCard());
    }

    @Test
    void getNumberOfCardsInDeck() {
        Deck d = new Deck();
        assertEquals(52, d.getNumberOfCardsInDeck());
    }

    @Test
    void createDeck() {
        Deck d = new Deck();
        d.createDeck();
    }
}