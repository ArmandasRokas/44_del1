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
     * This method rolls two dices and adds score to player
     */
    public void playRound() {  // Måske ændre navn til newRound() ?
        d1.rollDie();
        d2.rollDie();

        int totalEye = getCurrentRollScore();

        board.updateCurrSquare(totalEye);


        int currCashInfluence = this.getCurrCashInfluence();

        this.currPlayer.addToCash(currCashInfluence); // skal opdateres så den bruger getCurrCashInfluence
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
    public Player getP1() {
        return p1;
    }
    public Player getP2() {
        return p2;
    }
    public Player getCurrentplayer() {
        return currPlayer;
    }
}

