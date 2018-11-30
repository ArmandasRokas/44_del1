package model.squareTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the StartSquare class and its field and methods
 * Class to represent the "Start"-square of the board
 */
public class StartSquare extends Square {

    /**
     * Constructor of StartSquare
     *
     * @param scenario  Name of the square
     */
    public StartSquare(String scenario){
        super(scenario);
    }

    /**
     * Nothing happens on the "Start"-square
     *
     * @param p Instance of player who have landed on the square
     */
    @Override
    public void landedOn(Player p) {
    }

}
