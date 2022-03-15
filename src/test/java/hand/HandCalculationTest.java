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
    void checkHighCardsAboveBoundary() {
        //18
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,H");
        aiCards.add("6,S");

        assertTrue(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsEqualsBoundary() {
        //17
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,H");
        aiCards.add("5,S");

        assertTrue(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsUnderBoundary() {
        //16
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("4,s");

        assertFalse(new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsRlyHighCardsAboveBoundary(){
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("11,H");
        aiCards.add("11,S");

        assertTrue(new HandCalculation(aiCards).getRlyHighCards());
    }

    @Test
    void checkHighCardsRlyHighCardsEqualsBoundary(){
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("10,H");
        aiCards.add("10,S");

        assertTrue(new HandCalculation(aiCards).getRlyHighCards());
    }

    @Test
    void checkHighCardsRlyHighCardsUnderBoundary(){
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("9,H");
        aiCards.add("9,S");

        assertFalse(new HandCalculation(aiCards).getRlyHighCards());
    }

    @Test
    void checkSuit() {

    }

    @Test
    void checkStraight() {
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("2,H");
        aiCards.add("3,S");
        aiCards.add("4,S");
        aiCards.add("5,S");
        aiCards.add("8,S");

        HandCalculation handCalculation = new HandCalculation(aiCards);

        System.out.println(handCalculation.getStraightChance());
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