package model;

import util.GameTool;

/**@author  Hold 44
 * @version 11/10-2018
 *
 * Defines the Die class
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
     * Get method for Eyes
     *
     * @return Value of Eyes
     */
    public int getEyes() {
        return eyes;
    }



    public void rollDie() {
        this.eyes = GameTool.randomIntValue(minEyes,maxEyes);



    }





}
