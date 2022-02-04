package hand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandCalculationTest {

    @Test
    void getCardValues() {
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("6,s");
        aiCards.add("2,c");
        aiCards.add("3,d");

        HandCalculation handCalculation = new HandCalculation(aiCards);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(6);
        numbers.add(2);
        numbers.add(3);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("h");
        colors.add("s");
        colors.add("c");
        colors.add("d");

        assertAll(
                () -> assertEquals(numbers, handCalculation.getCardNbr()),
                () -> assertEquals(colors, handCalculation.getCardClr())
        );
    }

    @Test
    void checkPairAndMore() {
    }

    @Test
    void checkHighCardsAbove() {
        //18
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,H");
        aiCards.add("6,S");

        assertTrue(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsEquals() {
        //17
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,H");
        aiCards.add("5,S");

        assertTrue(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsUnder() {
        //16
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("4,s");

        assertFalse(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkSuit() {
    }

    @Test
    void checkStraight() {
    }

    @Test
    void getToHighlight() {
    }

    @Test
    void calcPwrBarLvl() {
    }

    @Test
    void pwrBarLvlOnTurnOne() {
    }

    @Test
    void pwrBarLvlOnTurnTwo() {
    }

    @Test
    void pwrBarLvlOnTurnThree() {
    }

    @Test
    void pwrBarLvlOnTurnFour() {
    }

    @Test
    void help() {
    }

    @Test
    void advice() {
    }

    @Test
    void toHiglight() {
    }

    @Test
    void calcHandstrenght() {
    }
}