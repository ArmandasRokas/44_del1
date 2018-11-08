package controller;

import model.Board;
import model.Die;
import model.Player;

/**@author Hold 44
 * Defines Game and all its global variables
 */
public class Game {
    private Player p1, p2, currPlayer;      //Instances of Player
    private Die d1, d2;                     //Instances of Die
    private Board board;

    public String getCurrScenario() {
        return board.getCurrScenerio();
    }

    public int getCurrCashInfluence() {
        return board.getCurrCashInfluence();
    }

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
    }

    /**
     * This constructor is just for testing purposes!
     */
    public Game(Player p1){
        this.p1 = p1;
        this.p2 = new Player("Spiller 2");
        this.d1 = new Die(1,6);
        this.d2 = new Die(1,6);
        this.currPlayer = p1;
    }

    /**
     * This method rolls two dices and adds score to player
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
     * Method to control if a winner has been found.
     *
     * @return  boolean of if winner has been found.
     */
    //TODO skal overvejes til at flytte metodens loggiken til Player class
    public boolean winnerFound() {
        boolean res = false;
        if(currPlayer.getTotalCash() >= 3000) {
            res = true;
        }
        return res;
    }

    /**
     * Set up round for next player
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
     * Add the eyes of the two dices
     *
     * @return  Sum of the two dices
     */
    public int getCurrentRollScore() {
        return d1.getEyes() + d2.getEyes();
    }



    /**
     * Get methods to get instance of Player
     *
     * @return  Instance of Player
     */

    public String getCurrPlayerNumber(){ return currPlayer.getNumber(); }
    public int getPlayerTotalCash(int playerNumber){
        if (playerNumber == 1){
            return p1.getTotalCash();
        } else{
            return p2.getTotalCash();
        }
    }
    public boolean checkExtraTurn(){
        return board.checkExtraTurn();
    }
}

