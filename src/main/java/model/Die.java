package model;

import util.GameTool;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the Die class and all of its fields and methods
 * Class to represent a single die to be used throughout the game
 */
public class Die {
    private int eyes;   //Eyes of the dice
    private int minEyes, maxEyes;   //Range of eyes on the die

    /**
     * Constructor of the Die
     */
    public Die(int minEyes, int maxEyes) {
       this.eyes = minEyes;
       this.minEyes = minEyes;
       this.maxEyes = maxEyes;
    }

    /**
     * Sets the eyes on the die through a pseudorandom method in GameTool class
     */
    public void rollDie() {
        this.eyes = GameTool.randomIntValue(minEyes,maxEyes);
    }

    /**
     * Get method for Eyes
     *
     * @return Number of current eyes on the die
     */
    public int getEyes() {
        return eyes;
    }
}