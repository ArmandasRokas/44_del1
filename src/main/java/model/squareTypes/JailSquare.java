package model.squareTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the JailSquare class and its field and methods
 * Class to represent the "Jail"-square of the board
 */
public class JailSquare extends Square {

    /**
     * Constructor of JailSquare
     *
     * @param scenario  Name of the square
     */
    public JailSquare(String scenario){
        super(scenario);
    }

    /**
     * Nothing happens on the "Jail"-square when you land on it - you are only visiting!
     *
     * @param p Instance of player who have landed on the square
     */
    @Override
    public void landedOn(Player p) {

    }

    /**
     * toString method of JailSquare
     *
     * @return  Scenario of the square
     */
    @Override
    public String toString() {
        return "You are visiting " + super.toString();
    }
}
