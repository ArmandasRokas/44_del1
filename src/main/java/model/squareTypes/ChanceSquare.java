package model.squareTypes;

import model.GameBoard;
import model.Player;
import model.chanceCardTypes.*;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the ChanceSquare class and its field and methods
 * Class to represent the "Chance Card"-square of the board
 */
public class ChanceSquare extends Square {
    private ChanceCard[] chanceCards;   //Deck of cards
    private int deckSize;               //The size of the deck of cards
    private int cardsDrawn = 0;         //Integer to determine which card is to be drawn, 0 being the first
    private ChanceCard currCard;        //The card most recently drawed

    /**
     * Constructor of ChanceSquare
     *
     * @param scenario  Name of the square
     * @param players   List of players currently playing (used on some cards atm)
     * @param gameBoard Instance of GameBoard
     */
    //FixMe Can't be right with this direct reference to Players.. Find a solution later, properly a Controller or something like that
    public ChanceSquare(String scenario, Player[] players, GameBoard gameBoard){
        super(scenario);
        initChanceCards(players, gameBoard);
    }

    /**
     * Initiate the cards of the deck of Chance Cards
     *
     * @param players   List of players currently playing (used on some cards atm)
     * @param gameBoard Instance of GameBoard
     */
    //Todo Rest of the cards are to be implemented
    private void initChanceCards(Player[] players, GameBoard gameBoard){
        deckSize = 7; //Amount of cards

        chanceCards = new ChanceCard[deckSize]; //FixMe Remove hardcoding, for now let it have this excess amount

        chanceCards[0] = new CCOutOfJail("Use this card to get out of prison for free! Keep this card until needed.");

        chanceCards[1] = new CCMoneyInfluence("You've eaten too much candy! Pay 2M.", -2, false, players);
        chanceCards[2] = new CCMoneyInfluence("It's your birthday! Collect 1M from every other player.", 1, true, players);
        chanceCards[3] = new CCMoneyInfluence("You've done your homework! Collect 2M from the bank.", 2, false, players);

        chanceCards[4] = new CCMoveSquares("Move 5 space forward", 5);

        chanceCards[5] = new CCMoveToSquare("Move to Strandpromenaden", "TheBeach", gameBoard); //FixMe Correct here and in GameBoard setup.. Mby make a setup up class?
        chanceCards[6] = new CCMoveToSquare("Move to The Skate Park", "Skaterpark", gameBoard);

//        chanceCards[] = new CCMoveToColour();
        shuffleCards();
    }

    /**
     * Acts out the scenario of the square
     *
     * @param p Instance of player who have landed on the square
     */
    @Override
    public void landedOn(Player p) {
        ChanceCard card = drawCard();
        card.actOnCard(p);
    }

    /**
     * Draws the next card of the deck of Chance Cards
     *
     * @return  Instance of ChanceCard
     */
    public ChanceCard drawCard() {
        if(cardsDrawn == deckSize) {
            shuffleCards();
            cardsDrawn = 0;
        }
        currCard = chanceCards[cardsDrawn++]; //TODO Control "variable++" is correct here, never tried it in an array call before

        return currCard;
    }

    /**
     * Shuffles the deck of cards at a pseudorandom level
     */
    public void shuffleCards() {
        ChanceCard[] shuffledCards = new ChanceCard[deckSize];

        for(int cardsShuffled = 0; cardsShuffled < deckSize ; cardsShuffled++) {
            ChanceCard card = chanceCards[cardsShuffled];
            boolean cardShuffled = false;

            while(!cardShuffled){
                int randomPlacement = (int)(Math.random() * deckSize);
                if(shuffledCards[randomPlacement] == null) {
                    shuffledCards[randomPlacement] = card;
                    cardShuffled = true;
                }
            }
        }
        chanceCards = shuffledCards;
    }

    /**
     * Returns current deck. Only used for tests.
     *
     * @return
     */
    public ChanceCard[] getDeck() {
        return chanceCards;
    }

    /**
     * toString method of ChanceSquare
     *
     * @return  Scenario of the square
     */
    public String toString(){
        return "You have drawn a Chance Card!" + "\n" + currCard.getScenario();
    }
}