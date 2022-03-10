package deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValueTest {

    @Test
    void getCardValue() {
    }
    @Test
    void getCardValue2() {
        Card card = new Card(null, CardValue.TWO, null);
        assertEquals(2, card.getCardValue());
    }
    @Test
    void getCardValue3() {
        Card card = new Card(null, CardValue.THREE, null);
        assertEquals(3, card.getCardValue());
    }
    @Test
    void getCardValue4() {
        Card card = new Card(null, CardValue.FOUR, null);
        assertEquals(4, card.getCardValue());
    }
    @Test
    void getCardValue5() {
        Card card = new Card(null, CardValue.FIVE, null);
        assertEquals(5, card.getCardValue());
    }
    @Test
    void getCardValue6() {
        Card card = new Card(null, CardValue.SIX, null);
        assertEquals(6, card.getCardValue());
    }
    @Test
    void getCardValue7() {
        Card card = new Card(null, CardValue.SEVEN, null);
        assertEquals(7, card.getCardValue());
    }
    @Test
    void getCardValue8() {
        Card card = new Card(null, CardValue.EIGHT, null);
        assertEquals(8, card.getCardValue());
    }
    @Test
    void getCardValue9() {
        Card card = new Card(null, CardValue.NINE, null);
        assertEquals(9, card.getCardValue());
    }
    @Test
    void getCardValue10() {
        Card card = new Card(null, CardValue.TEN, null);
        assertEquals(10, card.getCardValue());
    }
    @Test
    void getCardValueJack() {
        Card card = new Card(null, CardValue.JACK, null);
        assertEquals(11, card.getCardValue());
    }
    @Test
    void getCardValueQueen() {
        Card card = new Card(null, CardValue.QUEEN, null);
        assertEquals(12, card.getCardValue());
    }
    @Test
    void getCardValueKing() {
        Card card = new Card(null, CardValue.KING, null);
        assertEquals(13, card.getCardValue());
    }
    @Test
    void getCardValueAce() {
        Card card = new Card(null, CardValue.ACE, null);
        assertEquals(14, card.getCardValue());
    }
    @Test
    void getCardValueInvalid() {
        Card card = new Card(null, null, null);
        assertNull(card);
    }

    }