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

    /**
     * Checks if the Eyes have the Value between 1 and 6
     *
     * @param eyes If they aren't within range of 1 and 6, it will print out and error
     */
    public void setEyes(int eyes) {
        if(1 <= eyes && eyes <= 6) {
            this.eyes = eyes;
        }
        else {
            System.out.println("Error");
        }
    }
    public void rollDie() {
        this.eyes = GameTool.randomIntValue(minEyes,maxEyes);



    }





}
