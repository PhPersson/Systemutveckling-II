package hand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandCalculationTest {

    @Test
    void getCardValues() {
    }

    @Test
    void checkPairAndMore() {
    }

    @Test
    void checkHighCardsAbove() {
        //18
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("6,s");

        assertEquals(true , new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsEquals(){
        //17
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("5,s");

        assertEquals(true , new HandCalculation(aiCards).checkHighCards());
    }

    @Test
    void checkHighCardsUnder(){
        //16
        ArrayList<String> aiCards = new ArrayList<>();
        aiCards.add("12,h");
        aiCards.add("4,s");

        assertEquals(false , new HandCalculation(aiCards).checkHighCards());
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