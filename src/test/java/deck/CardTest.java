package deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {


    @Test
    short getCardValue() {
        return 0;
    }

    @Test
    void getCardSuit() {
    }

    @Test
    void getCardIcon() {
    }

    @Test
    void setCardValue() {
    }

    @Test
    void testGetCardValue() {
        Card card = new Card();
        card.setCardValue(CardValue.FIVE);
        assertEquals(5 , card.getCardValue());
    }
}