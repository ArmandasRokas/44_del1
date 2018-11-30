package model.squareTypes;

import model.GameBoard;
import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the ToJailSquare class and its field and methods
 * Class to represent "Go to jail"-square on the board
 */
public class ToJailSquare extends Square {
    int squareNumber;       //The placement of the square on the board
    GameBoard gameBoard;    //Reference to instance of GameBoard

    /**
     * Constructor of ToJailSquare
     *
     * @param scenario  Name of the square
     * @param gameBoard Instance of GameBoard
     */
    public ToJailSquare(String scenario, GameBoard gameBoard){
        super(scenario);
        this.gameBoard = gameBoard;
    }

    /**
     * Acts out the square's scenario with the player who landed on it
     *
     * @param p Instance of player who have landed on the square
     */
    //TODO skal implementeres
    @Override
    public void landedOn(Player p) {
        this.squareNumber = findSquare(gameBoard);
        p.moveToSquare(squareNumber);
    }

    /**
     * Finds the "Prison"-square on the board
     *
     * @param gameBoard Instance of GameBoard
     * @return          Index of "Prison"-Square
     */
    //FixMe Should properly be renamed "findPrisonSquare(...)"
    private int findSquare(GameBoard gameBoard) {
        int index = gameBoard.findSquareByName("Prison");
        return index;
    }

    /**
     * toString method of ToJailSquare
     *
     * @return  Scenario of the square
     */
    @Override
    public String toString() {
        return "You go to " + super.toString();
    }
}