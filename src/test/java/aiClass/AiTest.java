package aiClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AiTest {

    @Test
    void setStartingHand() {
    }

    @Test
    void makeDecision() {

    }

    @Test
    void testMakeDecision() {
    }

    @Test
    void testMakeDecision1() {
    }

    @Test
    void setDecision() {
        Ai a = new Ai(500, "Johan");
        a.setDecision("decisionset");
        assertEquals("decisionset" ,a.getDecision());
    }

    @Test
    void getDecision() {
        Ai a = new Ai(500, "Johan");
        assertEquals("", a.getDecision());
    }

    @Test
    void aiPot() {
        Ai a = new Ai(25000, "Johan");
        assertEquals(25000, a.aiPot());
    }

    @Test
    void updateWinner() {
        Ai a = new Ai(500, "Johan");
        a.updateWinner(1000);
        assertEquals(1500, a.aiPot());
    }

    @Test
    void getName() {
        Ai a = new Ai(500, "Johan");
        assertEquals("Johan", a.getName());
    }

    @Test
    void setBigBlind() {
        Ai a = new Ai(500, "Johan");
        a.setBigBlind(5, true);
        assertEquals(true, a.getIsBigBlind());
    }

    @Test
    void setSmallBlind() {
        Ai a = new Ai(500, "Johan");
        a.setSmallBlind(5, false);
        assertEquals(false, a.getIsSmallBlind());
    }

    @Test
    void getIsSmallBlind() {
        Ai a = new Ai(500, "Johan");
        assertEquals(false, a.getIsSmallBlind());
    }

    @Test
    void getIsBigBlind() {
        Ai a = new Ai(500, "Johan");
        assertEquals(false, a.getIsBigBlind());
    }

    @Test
    void getPaidThisTurn() {
        Ai a = new Ai(500, "Johan");
        assertEquals(0, a.getPaidThisTurn());
    }

    @Test
    void setPaidThisTurn() {
        Ai a = new Ai(500, "Johan");
        a.setPaidThisTurn(25000);
        assertEquals(25000, a.getPaidThisTurn());
    }

    @Test
    void setSameTurn() {
        Ai a = new Ai(500, "Johan");
        a.setSameTurn(true);
    }

    @Test
    void getHighCard() {
        Ai a = new Ai(500, "Johan");
        assertEquals(0, a.getHighCard());
    }

    @Test
    void handStrength() {
        Ai a = new Ai(500, "Johan");
        assertEquals(0, a.handStrength());
    }

    @Test
    void getAllInViability() {
        Ai a = new Ai(500, "Johan");
        assertEquals(99, a.getAllInViability());
    }

    @Test
    void setAllInViability() {
        Ai a = new Ai(500, "Johan");
        a.setAllInViability(99);
        assertEquals(99, a.getAllInViability());
    }
}