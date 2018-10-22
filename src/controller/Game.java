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
        this.d1 = new Die();
        this.d2 = new Die();
        this.currPlayer = p1;
    }

    /**
     * This method rolls two dices and adds score to player
     */
    public void roll() {
        d1.setEyes(randomIntValue(1,6));
        d2.setEyes(randomIntValue(1,6));

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
     * Checks of the dices have the same value
     *
     * @return True if they are the same, else false
     */
    public boolean diceHasSameValue() {
        if (d1.getEyes() == d2.getEyes()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks dices for the same value, if false Switch player
     */
    public void switchPlayer() {
        if(!diceHasSameValue()){
            if (currPlayer.equals(p1)) {
                currPlayer = p2;
            } else if (currPlayer.equals(p2)) {
                currPlayer = p1;
            }
        }
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

