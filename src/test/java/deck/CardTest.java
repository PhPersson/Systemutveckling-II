package deck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getCardValue() {
        Card c = new Card(null, CardValue.FIVE, null);
        Assertions.assertEquals(5, c.getCardValue());
    }

    @Test
    void getCardSuit() {
        Card c = new Card(Suit.DIAMONDS, null, null);
        Assertions.assertEquals("DIAMONDS", c.getCardSuit());
    }

    @Test
    void getCardIcon() {
        Card c = new Card(null, null, null);
        Assertions.assertEquals(null, c.getCardIcon());
    }
}