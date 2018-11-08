package controller;

import model.Board;
import model.Die;
import model.Player;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Game and all its fields and methods
 * Represents the logic of the game throughout it. Is to act between the inputs from the ui layer and the domain layer
 * according to this logic
 */
public class Game {
    private Player p1, p2, currPlayer;      //Instances of Player
    private Die d1, d2;                     //Instances of Die
    private Board board;
    private int winCondition;

    /**
     * Constructor of Game class
     */
    public Game() {
        this.p1 = new Player("Spiller 1");
        this.p2 = new Player("Spiller 2");
        this.d1 = new Die(1,6);
        this.d2 = new Die(1,6);
        this.currPlayer = p1;
        this.board = new Board(11);
        this.winCondition = 3000;
    }

    /**
     * This constructor is just for testing purposes!
     */
    public Game(Player p1){
        this.p1 = p1;
        this.currPlayer = p1;
        this.winCondition = 3000;
    }

    /**
     * Plays the essentials of a players turn. Rolls the dices, checks on what effect it has
     * on the player and acts on it
     */
    public void playRound() {  // Måske ændre navn til newRound() ?
        d1.rollDie();
        d2.rollDie();

        int totalEye = getCurrentRollScore();
        board.updateCurrSquare(totalEye);

        int currCashInfluence = this.getCurrCashInfluence();
        this.currPlayer.addToCash(currCashInfluence);
    }

    /**
     * Method to control if a winner has been found
     *
     * @return  boolean which is true if a winner has been found
     */
    //TODO skal overvejes til at flytte metodens logik til Player class
    public boolean winnerFound() {
        boolean res = false;
        if(currPlayer.getTotalCash() >= winCondition) {
            res = true;
        }
        return res;
    }

    /**
     * Sets up round for next player if to be changed, else it does nothing
     */
    public void endRound() {
        if(!board.checkExtraTurn()) {
            this.changePlayer();
        }
    }

    /**
     * Changes current player
     */
    private void changePlayer() {
        if(currPlayer.equals(p1)) {
            this.currPlayer = p2;
        } else if(currPlayer.equals(p2)) {
            this.currPlayer = p1;
        }
    }

    /**
     * Addd the eyes of the two dices
     *
     * @return  Sum of the two dices
     */
    public int getCurrentRollScore() {
        return d1.getEyes() + d2.getEyes();
    }

    /**
     * Get methods to get instance of current player
     *
     * @return  Instance of Player
     */
    public String getCurrPlayerNumber(){
        return currPlayer.getNumber();
    }

    /**
     * Gets the total amount of cash currently stashed by a given player
     *
     * @param playerNumber  The number of which player is to be checked
     * @return              Amount of cash stashed
     */
    public int getPlayerTotalCash(int playerNumber){
        if (playerNumber == 1){
            return p1.getTotalCash();
        } else{
            return p2.getTotalCash();
        }
    }

    /**
     * Gets what scenario the current square is
     *
     * @return  String of what the scenario says
     */
    public String getCurrScenario() {
        return board.getCurrScenerio();
    }

    /**
     * Gets what effect of the current square has on the players account
     *
     * @return  An integer of what effect it will have on the players account
     */
    public int getCurrCashInfluence() {
        return board.getCurrCashInfluence();
    }

    /**
     * Controls if the Square is meant to give the player an extra turn
     *
     * @return  Boolean which is true if the player is to get an extra turn, else it is false
     */
    public boolean checkExtraTurn(){
        return board.checkExtraTurn();
    }
}