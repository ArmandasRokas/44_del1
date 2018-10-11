package controller;

import model.Die;
import model.Player;

import java.util.Random;

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
        d1.setEyes(randomValue());
        d2.setEyes(randomValue());

        this.currPlayer.addToScore(getCurrentRollScore());
    }

    /**
     * Calculates a random value between 1 and 6
     *
     * @return  Random integer between 1 and 6
     */
    public int randomValue() {
        Random r = new Random();

        int randomNum = r.nextInt(6); // 0-5
        int finalNum = randomNum + 1;        // 1-6

        return finalNum;
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


//public class Time {
//    public static void main(String[] args)
//    {
//        // starting time
//        long start = System.currentTimeMillis();
//
//        // start of function
//
//        count_function(10000000);
//
//        // end of function
//
//        // ending time
//        long end = System.currentTimeMillis();
//        System.out.println("Counting to 10000000 takes " +
//                (end - start) + "ms");
//    }