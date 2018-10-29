package controller;

import model.Die;
import model.Player;

import static util.GameTool.randomIntValue;

/**@author Hold 44
 * Defines Game and all its global variables
 */
public class Game {
    private Player p1, p2, currPlayer;      //Instances of Player
    private Die d1, d2;                     //Instances of Die

    /**
     * Constructor of Game class
     */
    public Game() {
        this.p1 = new Player("Spiller 1");
        this.p2 = new Player("Spiller 2");
        this.d1 = new Die(1,6);
        this.d2 = new Die(1,6);
        this.currPlayer = p1;
    }

    /**
     * This method rolls two dices and adds score to player
     */
    public void roll() {
        d1.rollDie();
        d2.rollDie();

        this.currPlayer.addToScore(getCurrentRollScore());
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

