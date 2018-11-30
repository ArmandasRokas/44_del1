package model.chanceCardTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the CCMoveSquares class and all of its fields and methods
 * Class to represent the cards of the game that moves the player a chosen amount of squares
 */
public class CCMoveSquares extends ChanceCard {
    private int squaresToMove;  //Number of squares players are to be moved

    /**
     * Constructor of CCMoveSquares
     *
     * @param scenario      Scenario description of the card
     * @param squaresToMove Number of squares players are to be moved
     */
    public CCMoveSquares(String scenario, int squaresToMove) {
        super(scenario);
        this.squaresToMove = squaresToMove;
    }

    /**
     * Moves the player the amount of squares he is to be moved
     *
     * @param p Player to be affected by the card
     */
    @Override
    public void actOnCard(Player p) {
        p.movePlayer(this.squaresToMove);
    }
}