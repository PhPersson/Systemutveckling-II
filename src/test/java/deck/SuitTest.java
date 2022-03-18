package deck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void getSuitLetter() {
        Assertions.assertEquals("d", Suit.DIAMONDS.getSuitLetter());
    }

    @Test
    void values() {
    }

    @Test
    void valueOf () {
    }
}