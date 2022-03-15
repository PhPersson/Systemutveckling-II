package hand;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Does the actuall calculation and decides what help
 * the noob player gets.
 *
 * @author Max Frennessen
 * @version 1.5
 * 17-04-12
 */
public class HandCalculation {
    private ArrayList<String> finalHighlight = new ArrayList<>();
    private ArrayList<String> numberForStraight = new ArrayList<>();
    private ArrayList<String> numberForStraight1 = new ArrayList<>();
    private ArrayList<String> aiCards;
    private ArrayList<Integer> cardNumber = new ArrayList<>();
    private ArrayList<String> cardColor = new ArrayList<>();
    private boolean highCards;
    private boolean lowCards = false;
    private boolean rlyHighCards = false;
    private int colorChance;
    private int straightChance;
    private int pairsAndMore;
    private String yourCard = "1,1";
    private String yourCard2 = "1,1";
    private String otherCard = "1,1";
    private String theColor;
    private ArrayList<String> toHighlight = new ArrayList<>();
    private String newAdvice;
    private String whatStraight;
    private int HandStrength = 0;

    /**
     * @param aiCards Current cards needed for evaluate.
     */
    public HandCalculation(ArrayList<String> aiCards) {
        this.aiCards = aiCards;
        getCardValues(aiCards);
        toHighlight.clear();
        highCards = checkHighCards();
        colorChance = checkSuit();
        pairsAndMore = checkPairAndMore();
        straightChance = checkStraight();

        Help();
    }

    public ArrayList<Integer> getCardNbr() {
        return cardNumber;
    }

    public ArrayList<String> getCardClr() {
        return cardColor;
    }

    int getStraightChance(){
        return straightChance;
    }

    boolean getRlyHighCards() {
        return rlyHighCards;
    }

    /**
     * converts the cards value into two diffirent arraylists.
     * one for cardnumber and one for cardcolor.
     *
     * @param aiCards current card being used
     */
    public void getCardValues(ArrayList<String> aiCards) {
        for (int i = 0; i < aiCards.size(); i++) {            //CardNumber
            String temp = aiCards.get(i);
            String[] splitter = temp.split(",");
            int tempInt = Integer.parseInt(splitter[0]);
            cardNumber.add(tempInt);
        }

        for (int i = 0; i < aiCards.size(); i++) {            //CardColor
            String temp = aiCards.get(i);
            String[] splitter = temp.split(",");
            String tempString = splitter[1];
            cardColor.add(tempString);
        }
    }

    /**
     * @return returns how many pairs or more the player has.
     */
    public int checkPairAndMore() {
        int same = 1;
        int nbrOftemp = 0;
        int nbrOftemp1 = 0;
        int nbrOftemp2 = 0;
        int size = aiCards.size();
        int[] cards = new int[size + 1];

        for (int i = 0; i < size; i++) {
            cards[i] = cardNumber.get(i);
        }

        if (cards[0] == cards[1]) {
            int temp = cards[0];
            nbrOftemp = 2;
            toHighlight.clear();
            toHighlight.add(aiCards.get(1));
            toHighlight.add(aiCards.get(0));
            yourCard = aiCards.get(0);
            otherCard = aiCards.get(1);

            for (int i = 2; i < cards.length; i++) {
                if (cards[i] == temp) {
                    nbrOftemp++;
                }
            }
        } else {
            int temp1 = cards[0];
            int temp2 = cards[1];

            nbrOftemp1 = 1;
            nbrOftemp2 = 1;

            for (int i = 2; i < cards.length; i++) {
                if (cards[i] == temp1) {
                    if (cards[i] + temp2 <= 10) {
                        lowCards = true;
                    }

                    if (cards[i] + temp2 > 17) {
                        highCards = true;
                    }

                    nbrOftemp1++;

                    yourCard = aiCards.get(0);
                    otherCard = aiCards.get(i);
                    yourCard2 = aiCards.get(0);
                }
                if (cards[i] == temp2) {
                    if (cards[i] + temp2 > 17) {
                        highCards = true;
                    }

                    if (cards[i] + temp2 <= 10) {
                        lowCards = true;
                    }

                    nbrOftemp2++;
                    yourCard = aiCards.get(1);
                    otherCard = aiCards.get(i);
                }
            }
        }

        if (nbrOftemp > 0) {
            same = nbrOftemp;
        }

        if (nbrOftemp1 > 1) {
            same = nbrOftemp1;
        }

        if (nbrOftemp2 > 1) {
            if (nbrOftemp1 > 1) {
                same = Integer.parseInt(nbrOftemp1 + "" + nbrOftemp2);
            } else
                same = nbrOftemp2;
        }

        if (same == 1) {
            same = 0;
        }

        return same;
    }

    /**
     * @return returns true if cards value >= 17.
     * 'rlyHigh not yet implemented.
     */
    public boolean checkHighCards() {
        boolean high = false;

        int card1 = cardNumber.get(0);
        int card2 = cardNumber.get(1);

        int total = (card1 + card2);

        if (total >= 17) {
            high = true;
        }

        if (card1 >= 10 && card2 >= 10) {
            rlyHighCards = true;
        }

        return high;
    }

    /**
     * @return returns if the player has a suit or even has a chance for one.
     */
    public int checkSuit() {
        int C = 0;
        int S = 0;
        int H = 0;
        int D = 0;
        int color = 0;

        for (String x : cardColor) {
            if (x.equals("S")) {
                S++;
            }

            if (x.equals("C")) {
                C++;
            }

            if (x.equals("D")) {
                D++;
            }

            if (x.equals("H")) {
                H++;
            }
        }

        if (S > color) {
            toHighlight.clear();
            color = S;
            theColor = "spader";

            for (int i = 0; i < cardColor.size(); i++) {
                String temp = cardColor.get(i);
                if (S == 5)
                    if (temp.equals("S")) {
                        toHighlight.add(aiCards.get(i));
                    }
            }
        }

        if (H > color) {
            toHighlight.clear();
            color = H;
            theColor = "hjärter";

            for (int i = 0; i < cardColor.size(); i++) {
                String temp = cardColor.get(i);
                if (H == 5)
                    if (temp.equals("H")) {
                        toHighlight.add(aiCards.get(i));
                    }
            }
        }

        if (D > color) {
            toHighlight.clear();
            color = D;
            theColor = "ruter";

            for (int i = 0; i < cardColor.size(); i++) {
                String temp = cardColor.get(i);
                if (D == 5)
                    if (temp.equals("D")) {
                        toHighlight.add(aiCards.get(i));
                    }
            }
        }

        if (C > color) {
            toHighlight.clear();
            color = C;
            theColor = "klöver";

            for (int i = 0; i < cardColor.size(); i++) {
                String temp = cardColor.get(i);
                if (C == 5)
                    if (temp.equals("C")) {
                        toHighlight.add(aiCards.get(i));
                    }
            }
        }

        return color;
    }

    /**
     * @return returns if the player has a straight or even has a chance for one.
     */
    public int checkStraight() {
        int threshold = 0;

        int[] correctOrderArray = new int[cardNumber.size()];

        for (int i = 0; i < cardNumber.size(); i++) {            //as referance when getting to highlight.
            correctOrderArray[i] = cardNumber.get(i);
        }

        for (int i = 0; i < cardNumber.size(); i++) {
            if (cardNumber.get(i) == 14) {
                cardNumber.add(1);
            }
        }

        int[] currentCardsArray = new int[cardNumber.size()];

        for (int i = 0; i < cardNumber.size(); i++) {
            currentCardsArray[i] = cardNumber.get(i);
        }

        Arrays.sort(currentCardsArray);
        int inStraight;
        int check = 4;

        for (int x = 0; x < currentCardsArray.length; x++) {
            int CurrentHighestInStraight = currentCardsArray[x] + check;
            int CurrentLowestInStraight = currentCardsArray[x];
            String tempStraight = CurrentLowestInStraight + "-" + CurrentHighestInStraight;

            inStraight = 0;

            for (int i = 0; i < currentCardsArray.length; i++) {
                if (currentCardsArray[i] <= CurrentHighestInStraight && !(currentCardsArray[i] < CurrentLowestInStraight)) {
                    if (i == 0) {                            //kollar om 0 är samma som 1.
                        inStraight++;

                        if (currentCardsArray[i] == 1) {
                            numberForStraight.add(String.valueOf(currentCardsArray[currentCardsArray.length - 1]));
                        } else {
                            numberForStraight.add(String.valueOf(currentCardsArray[i]));
                        }
                    }

                    if (i >= 1) {
                        if (!(currentCardsArray[i] == currentCardsArray[i - 1])) {        //kollar om 1-4 är samma som nån annan.
                            inStraight++;
                            numberForStraight.add(String.valueOf(currentCardsArray[i]));
                        }
                    }
                }
            }

            if (inStraight >= threshold) {  // >= så om man får 5 igen men med högre tal så blir det den som visas.
                threshold = inStraight;
                whatStraight = tempStraight;
                numberForStraight1.clear();

                numberForStraight1.addAll(numberForStraight);
            }

            numberForStraight.clear();
        }

        return threshold;
    }

    public ArrayList<String> getToHighlight() {
        for (String s : numberForStraight1) {
            int same = 1;

            for (String temp : aiCards) {
                String[] tempSplit = temp.split(",");

                if (s.equals(tempSplit[0])) {
                    if (same == 1) {
                        finalHighlight.add(temp);
                        same++;
                    }
                }
            }
        }

        return finalHighlight;
    }


    public int calcPwrBarLvl() {
        int powerBar = 1;
        //TURNONE PWRLEVEL
        if (aiCards.size() == 2) {
            powerBar = powerBarLvlOnTurnOne();
        }
        //TURNTWO PWRLEVEL
        if (aiCards.size() == 5) {
            powerBar = powerBarLvlOnTurnTwo();
        }
        //TURNTHREE PWRLEVEL
        if (aiCards.size() == 6) {
            powerBar = powerBarLvlOnTurnThree();
        }
        //TURNFOUR PWRLEVEL
        if (aiCards.size() == 7) {
            powerBar = pwrBarLvlOnTurnFour();
        }

        return powerBar;
    }

    public int powerBarLvlOnTurnOne() {
        int powerBar = 1;

        if (colorChance == 2) {
            powerBar = 2;
        }

        if (highCards) {
            powerBar = 2;
            if (rlyHighCards) {
                powerBar = 3;
            }
        }

        if (straightChance == 2) {
            powerBar = 2;

            if (rlyHighCards) {
                powerBar = 3;
            }

            if (colorChance == 2) {
                powerBar = 3;
            }
        }

        if (pairsAndMore > 0) {
            powerBar = 4;
        }

        return powerBar;
    }

    public int powerBarLvlOnTurnTwo() {
        int powerBar = 1;

        if (highCards) {
            if (rlyHighCards) {
                powerBar = 2;
            }
        }

        if (colorChance == 3) {
            powerBar = 2;
        }

        if (straightChance >= 2) {
            powerBar = 2;

            if (straightChance >= 4) {
                powerBar = 3;
            }

            if (colorChance == 3) {
                powerBar = 3;
            }
        }

        if (pairsAndMore == 2) {
            powerBar = 3;
        }

        if (pairsAndMore == 22) {
            powerBar = 4;
        }

        if (pairsAndMore == 3) {
            powerBar = 4;
        }

        if (pairsAndMore == 4 || pairsAndMore == 24) {
            powerBar = 4;
        }

        if (pairsAndMore == 23 || pairsAndMore == 32) {
            powerBar = 4;
        }

        if (straightChance == 5 || colorChance == 5) {
            powerBar = 4;
        }

        return powerBar;
    }

    public int powerBarLvlOnTurnThree() {
        int powerBar = 1;

        if (highCards) {
            if (rlyHighCards) {
                powerBar = 2;
            }
        }

        if (colorChance == 4) {
            powerBar = 2;
        }

        if (straightChance == 4) {
            powerBar = 2;

            if (colorChance == 4) {
                powerBar = 3;
            }
        }

        if (pairsAndMore == 2) {
            powerBar = 2;
        }

        if (pairsAndMore == 22) {
            powerBar = 3;
        }

        if (pairsAndMore == 3) {
            powerBar = 4;
        }

        if (pairsAndMore == 4 || pairsAndMore == 24) {
            powerBar = 4;
        }

        if (pairsAndMore == 23 || pairsAndMore == 32) {
            powerBar = 4;
        }

        if (straightChance == 5 || colorChance == 5) {
            powerBar = 4;
        }

        return powerBar;
    }

    public int pwrBarLvlOnTurnFour() {
        int powerBar = 1;

        if (pairsAndMore == 2) {
            powerBar = 2;
        }

        if (pairsAndMore == 22) {
            powerBar = 3;
        }

        if (pairsAndMore == 3) {
            powerBar = 4;
        }

        if (pairsAndMore == 4 || pairsAndMore == 24) {
            powerBar = 4;
        }

        if (pairsAndMore == 23 || pairsAndMore == 32) {
            powerBar = 4;
        }

        if (straightChance == 5 || colorChance == 5) {
            powerBar = 4;
        }

        return powerBar;
    }

    /**
     * @return returns a advice for the player that is current for his or her hand.
     */
    public String Help() {
        String helper = "Ingenting, tyvärr...";
        String advice = "Denna hand kanske inte är den bästa att spela på...";

        String[] splitter = yourCard.split(",");
        int intCardNbr = Integer.parseInt(splitter[0]);
        String yourCardInt = String.valueOf(intCardNbr);
        String cardOne = cardNumber.get(0) + ":or";
        String cardTwo = cardNumber.get(1) + ":or";

        if (cardNumber.get(0) > 10) {
            if (cardNumber.get(0) == 11) {
                cardOne = "Knektar";
            }

            if (cardNumber.get(0) == 12) {
                cardOne = "Damer";
            }

            if (cardNumber.get(0) == 13) {
                cardOne = "Kungar";
            }

            if (cardNumber.get(0) == 14) {
                cardOne = "Ess";
            }
        }

        if (cardNumber.get(1) > 10) {
            if (cardNumber.get(1) == 11) {
                cardTwo = "Knektar";
            }

            if (cardNumber.get(1) == 12) {
                cardTwo = "Damer";
            }

            if (cardNumber.get(1) == 13) {
                cardTwo = "Kungar";
            }

            if (cardNumber.get(1) == 14) {
                cardTwo = "Ess";
            }
        }

        if (intCardNbr < 11) {
            yourCardInt += ":or";
        }

        if (intCardNbr > 10) {
            if (intCardNbr == 11) {
                yourCardInt = "Knektar";
            }

            if (intCardNbr == 12) {
                yourCardInt = "Damer";
            }

            if (intCardNbr == 13) {
                yourCardInt = "Kungar";
            }

            if (intCardNbr == 14) {
                yourCardInt = "Ess";
            }

        }
        //Writing out what advice to give and help for player, starting to check the lowest possible and if the player has better than it,
        //im overwriting it with a better card. starting from high card only and ending on straight flush.

        //HIGH CARD
        advice = "Du har bara 'HIGH CARD'. \nOm det är billigt så kan du prova och se.\n";

        if (highCards) {
            advice = "Du har ett högt 'HIGH CARD'. \nOm det är billigt så kan du prova och se.\n";
        }

        // ONE PAIR
        if (pairsAndMore == 2) {
            helper = "'ONE-PAIR' i " + yourCardInt + "\n";
            if (aiCards.size() == 2) {
                advice = "'ONE-PAIR' på första-handen är en stark hand!\nSå kör på!\n";
                if (highCards) {
                    advice = "'ONE-PAIR' på första-handen är en stark hand!\nOch då detta är även är ett högt par, Så kör verkligen!!\n";
                }
            }

            if (aiCards.size() == 5) {
                advice = "'ONE-PAIR' är en ok hand. Om det inte kostar för mycket. Så kör på!\n";
                if (lowCards) {
                    advice = "'ONE-PAIR' är en ok hand, även då detta är ett lågt par.\nOm det inte kostar för mycket. Så kör på!\n";
                }

                if (highCards) {
                    advice = "'ONE-PAIR' är en ok hand. Och detta är även ett högt par vilket är ännu bättre.\nOm det inte kostar för mycket. Kör på!\n";
                }
            }

            if (aiCards.size() > 5) {
                advice = "'ONE-PAIR' är en hyfsat ok hand. Om det inte kostar för mycket. Så kör på!\n";
                if (lowCards) {
                    advice = "'ONE-PAIR' är en hyfsat ok hand, även då detta är ett lågt par.\nOm det inte kostar för mycket. Så kör på!\n";
                }

                if (highCards) {
                    advice = "'ONE-PAIR'  är en hyfsat ok hand. Och detta är även ett högt par vilket är ännu bättre.\nOm det inte kostar för mycket."
                            + " Kör på!\n";
                }
            }

            // writes the active cards to highlight
            if (straightChance < 5 && colorChance < 5) {
                toHighlight.clear();

                for (String aiCard : aiCards) {
                    String[] seeIfSame = aiCard.split(",");
                    int temp = Integer.parseInt(seeIfSame[0]);
                    if (intCardNbr == temp) {
                        toHighlight.add(aiCard);
                    }
                }
            }
        }

        //TWO PAIRS
        if (pairsAndMore == 22) {
            helper = "'TWO PAIRS'  i " + cardOne + " och " + cardTwo;
            advice = "'TWO PAIRS' är en bra hand, kör på.\n";

            // writes the active cards to hihglight
            if (straightChance < 5 && colorChance < 5) {
                toHighlight.clear();

                for (int i = 0; i < aiCards.size(); i++) {
                    int cardIntOne = cardNumber.get(0);
                    int cardIntTwo = cardNumber.get(1);

                    if (cardIntOne == cardNumber.get(i)) {
                        toHighlight.add(aiCards.get(i));
                    }

                    if (cardIntTwo == cardNumber.get(i)) {
                        toHighlight.add(aiCards.get(i));
                    }
                }
            }
        }

        //STRAIGHT
        if (straightChance == 5) {
            helper = "En 'STRAIGHT'!! Du har 5/5.\n";
            advice = "En 'STRAIGHT' är en riktigt bra hand. Kör på! \nFundera även på att höja!\n";
            toHighlight.clear();
            toHighlight = getToHighlight();
        }

        //FLUSH
        if (colorChance == 5) {
            helper = "En 'FLUSH' i " + theColor + "!! Du har 5/5!!\n";
            advice = "Du har en 'FLUSH'! Kör på, din hand är svår att slå!\n";
            //To HIHGLIGHT IS IN checkSuit Method.
            toHighlight.clear();
            checkSuit();
        }

        //FULL HOUSE
        if (pairsAndMore == 23 || pairsAndMore == 32) {
            helper = "'FULL HOUSE' med " + cardOne + " och " + cardTwo + "!!";
            advice = "Det är inte mycket som slår denna hand! Höja är rekomenderat!\n";
            // writes the active cards to hihglight
            toHighlight.clear();

            for (int i = 0; i < aiCards.size(); i++) {
                int cardIntOne = cardNumber.get(0);
                int cardIntTwo = cardNumber.get(1);

                if (cardIntOne == cardNumber.get(i)) {
                    toHighlight.add(aiCards.get(i));
                }

                if (cardIntTwo == cardNumber.get(i)) {
                    toHighlight.add(aiCards.get(i));
                }
            }
        }

        //FOUR OF A KIND
        if (pairsAndMore == 4 || pairsAndMore == 42 || pairsAndMore == 24) {
            helper = "'FOUR OF A KIND' i " + yourCardInt;
            advice = "'FOUR OF A KIND' är en av de bästa händerna. \nKör på! Fundera även på att höja!";

            // writes the active cards to hihglight
            if (straightChance < 5 && colorChance < 5) {
                toHighlight.clear();

                for (String aiCard : aiCards) {
                    String[] seeIfSame = aiCard.split(",");
                    int temp = Integer.parseInt(seeIfSame[0]);
                    if (intCardNbr == temp) {
                        toHighlight.add(aiCard);
                    }
                }
            }
        }

        //STRAIGHT FLUSH
        if (straightChance == 5 && colorChance == 5) {                            //"i stegen  " + whatStraight;
            helper = "'STRAIGHT FLUSH' i färgen " + theColor + "! ";   //ev add what straight it is ex 2-6.
            advice = "'STRAIGHT FLUSH' är bästa handen i spelet. Kör på och höj!\n";
            // Highlightning happens in checkStraight and checkSuit.
        }

        //THREE OF A KIND
        if (pairsAndMore == 3) {
            helper = "'THREE OF A KIND' i " + yourCardInt;
            advice = "'THREE OF A KIND' är en väldigt stark hand. \nKör på! Fundera även på att höja!";

            // writes the active cards to hihglight
            if (straightChance < 5 && colorChance < 5) {
                toHighlight.clear();

                for (String aiCard : aiCards) {
                    String[] seeIfSame = aiCard.split(",");
                    int temp = Integer.parseInt(seeIfSame[0]);
                    if (intCardNbr == temp) {
                        toHighlight.add(aiCard);
                    }
                }
            }
        }

        //STRAIGHTCHANCE TEXT AND COLORCHANCE TEXT
        if (aiCards.size() < 3) {
            if (straightChance == 2) {
                advice += "Du har en chans på en 'STRAIGHT', du har 2/5. \n";
            }

            if (colorChance == 2) {
                advice += "Du har en chans för en 'FLUSH' i " + theColor + ", du har 2/5.\n";
            }
        }

        if (aiCards.size() < 6) {
            if (straightChance == 3) {
                advice += "Du har en chans på en 'STRAIGHT', du har 3/5.\n";
            }

            if (colorChance == 3) {
                advice += "Du har en chans för en 'FLUSH' i " + theColor + ", du har 3/5.\n";
            }
        }

        if (aiCards.size() < 7) {
            if (straightChance == 4) {
                advice += "Du har en chans på en 'STRAIGHT', du har 4/5.\n";
            }

            if (colorChance == 4) {
                advice += "Du har en chans för en 'FLUSH' i " + theColor + ", du har 4/5.\n";
            }
        }

        newAdvice = advice;

        return helper;
    }

    /**
     * returns what advice to give the user
     *
     * @return what advice to give the user
     */
    public String advice() {
        return newAdvice;
    }

    /**
     * @return what to be highlighed.
     */
    public ArrayList<String> toHighlight() {
        return toHighlight;

    }

    /**
     * sets and returns the current handStrength of the users cards.
     *
     * @return sets and returns the current handStrength of the users cards.
     */
    public int calcHandStrength() {
        if (pairsAndMore == 2) {     //Pair
            HandStrength = 1;
        }

        if (pairsAndMore == 22) {     //Two pair
            HandStrength = 2;
        }

        if (pairsAndMore == 3) {     //Three of a kind
            HandStrength = 3;
        }

        if (straightChance == 5) {    //Straight
            HandStrength = 4;
        }

        if (colorChance == 5) {        //Flush
            HandStrength = 5;
        }

        if (pairsAndMore == 23 || pairsAndMore == 32) {    //Full house
            HandStrength = 6;
        }

        if (pairsAndMore == 4 || pairsAndMore == 42 || pairsAndMore == 24) {    //Four of a kind
            HandStrength = 7;
        }

        if (colorChance == 5 && straightChance == 5) {        //Straight flush
            HandStrength = 8;
        }

        return HandStrength;
    }
}
