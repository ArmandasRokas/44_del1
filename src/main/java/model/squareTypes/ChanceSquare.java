package model.squareTypes;

import model.Board;
import model.Player;
import model.chanceCardTypes.*;

import java.util.ArrayList;

public class ChanceSquare extends Square {
    private static ChanceCard[] chanceCards;
    private static int deckSize;
    private static int cardsDrawn = 0;

    public ChanceSquare(String scenario, Player[] players, Board board){
        super(scenario);
        initChanceCards(players, board);
    }

    //Todo skal implementeres
    private void initChanceCards(Player[] players, Board board){
        deckSize = 7; //Amount of cards

        chanceCards = new ChanceCard[deckSize]; //FixMe Remove hardcoding, for now let it have this excess amount

        chanceCards[0] = new CCOutOfJail("Use this card to get out of prison for free! Keep this card until needed.");

        chanceCards[1] = new CCMoneyInfluence("You've eaten too much candy! Pay 2M.", -2, false, players);
        chanceCards[2] = new CCMoneyInfluence("It's your birthday! Collect 1M from every other player.", 1, true, players);
        chanceCards[3] = new CCMoneyInfluence("You've done your homework! Collect 2M from the bank.", 2, false, players);

        chanceCards[4] = new CCMoveSquares("Move 5 space forward", 5);

        chanceCards[5] = new CCMoveToSquare("Move to Strandpromenaden", "TheBeach", board); //FixMe Correct here and in Board setup.. Mby make a setup up class?
        chanceCards[6] = new CCMoveToSquare("Move to The Skate Park", "Skaterpark", board);

//        chanceCards[] = new CCMoveToColour();
    }

    @Override
    public void landedOn(Player p) {

        // Todo getRandomCard skal implementeres
//        int index = getRandomCard();
//        chanceCards[index].actOnCard(p);
        ChanceCard card = drawCard();
        card.actOnCard(p);
    }

    private ChanceCard drawCard() {
        ChanceCard card;

        if(cardsDrawn == deckSize) {
            shuffleCards();
            cardsDrawn = 0;
        }
        card = chanceCards[cardsDrawn++]; //TODO Control "variable++" is correct here, never tried it in an array call before

        return card;
    }

    private void shuffleCards() {
        ChanceCard[] shuffledCards = new ChanceCard[deckSize];

        for(int cardsShuffled = 0; cardsShuffled < deckSize ; cardsShuffled++) {
            ChanceCard card = chanceCards[cardsShuffled];
            boolean cardShuffled = false;

            while(!cardShuffled){
                int randomPlacement = (int)(Math.random() * deckSize);
                if(shuffledCards[randomPlacement] != null) {
                    shuffledCards[randomPlacement] = card;
                    cardShuffled = true;
                }
            }
        }
        chanceCards = shuffledCards;
    }
}