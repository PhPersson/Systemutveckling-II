package aiClass;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AiDecideTest {

    @Test
    void turnOne() {
    }

    @Test
    void turnTwo() {
    }

    @Test
    void turnThree() {
    }

    @Test
    void turnFour() {
    }

    @Test
    void gethandStrength() {
        ArrayList<String> aiCards = new ArrayList<String>();
        AiDecide ai = new AiDecide(aiCards, 500, 200, 100, true);
        ai.gethandStrength();
    }

    @Test
    void updateAiPot() {
    }

    @Test
    void decision() {
    }
}