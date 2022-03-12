package hand;

import java.util.ArrayList;

import deck.Card;

/**
 * The hand-class that will guide and help the noob player.
 *
 * @author Max Frennessen 17-05-25
 * @version 2.0
 */
public class Hand {
    private HandCalculation handCalculation;
    private ArrayList<Card> cards;
    private ArrayList<String> aiCards = new ArrayList<>();
    private ArrayList<String> toHighlight;
    private String helper;
    private String advice;
    private int powerBar, handStrength;

    /**
     * Constructor
     *
     * @param cards gets card that are important for this turn.
     */
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
        convertToReadable();

        handCalculation = new HandCalculation(aiCards);
        helper = handCalculation.Help();
        advice = handCalculation.advice();
        powerBar = handCalculation.calcPwrBarLvl();
        toHighlight = handCalculation.toHighlight();
    }


    /**
     * Converts the cards into readable Strings.
     */
    public void convertToReadable() {
        for (Card cardTemp : cards) {
            char A = cardTemp.getCardSuit().charAt(0);
            String temp = cardTemp.getCardValue() + "," + A;
            aiCards.add(temp);
        }
    }


    /**
     * Recalculates advice and which cards to highlight. Required when adding and removing cards.
     */
    public void reCalc() {
        this.handCalculation = new HandCalculation(aiCards);
        this.advice = handCalculation.advice();
        this.toHighlight = handCalculation.toHighlight();
    }

    /**
     * returns a number that will be used to set a image to visualize the users handStrength
     *
     * @return a int that represents the users cardStregnth
     */
    public int toPowerBar() {
        return powerBar;
    }

    /**
     * returns the Text that will be shown to the user
     *
     * @return a String of text to help the user
     */
    public String theHelp() {
        return helper;
    }

    /**
     * returns the advice the program gives the user this turn.
     *
     * @return returns the advice the program gives the user this turn.
     */
    public String theAdvice() {
        return advice;
    }

    /**
     * @return returns what is supposed to be highlighted.
     */
    public ArrayList<String> getHighlightedCards() {
        return toHighlight;
    }

    /**
     * returns the current handstrength
     *
     * @return returns the current handstrength
     */
    public int getHandStrength() {
        handStrength = handCalculation.calcHandStrength();

        return handStrength;
    }
}
