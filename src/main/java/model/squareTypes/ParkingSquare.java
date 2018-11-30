package model.squareTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the ParkingSquare class and its field and methods
 * Class to represent the "Parking"-square of the board
 */
public class ParkingSquare extends Square {

    /**
     * Constructor of ParkingSquare
     *
     * @param scenario  Name of the square
     */
    public ParkingSquare(String scenario){
        super(scenario);
    }

    /**
     * Nothing happens when you land on the "Parking"-square
     *
     * @param p Instance of player who have landed on the square
     */
    @Override
    public void landedOn(Player p) {    }
}
