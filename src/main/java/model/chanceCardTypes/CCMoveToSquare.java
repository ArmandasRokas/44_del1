package model.chanceCardTypes;

import model.GameBoard;
import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the CCMoveToSquare class and all of its fields and methods
 * Class to represent the cards of the game that sends the player to a specific square
 */
public class CCMoveToSquare extends ChanceCard {
    private String squareName;      //Name of square, card is to send player to
//    private int squareNmb;
    private GameBoard gameBoard;    //Reference to instance of GameBoard

    /**
     * Constructor of CCMoveToSquare
     *
     * @param scenario      Scenario description of the card
     * @param squareName    Name of the square, card is to send player to
     * @param gameBoard     Reference to instance of GameBoard
     */
    public CCMoveToSquare(String scenario, String squareName, GameBoard gameBoard) {
        super(scenario);
        this.squareName = squareName;
        this.gameBoard = gameBoard;
//        this.squareNmb = findSquare(squareName, gameBoard);
    }

    /**
     * Moves the player to the determined square
     *
     * @param p Player to be affected by the card
     */
    //FixMe Could properly be better to just have the index-nmb of the square instead - less calls through the program that way
    @Override
    public void actOnCard(Player p) {
        p.moveToSquare(findSquare(squareName, gameBoard));
    }

    /**
     * Finds the index of the square by the name of it
     *
     * @param squareName    Name of the square, card is to send player to
     * @param gameBoard     Reference to instance of GameBoard
     * @return              Index of Square class on list of square on GameBoard
     */
    private int findSquare(String squareName, GameBoard gameBoard) {
        int index = gameBoard.findSquareByName(squareName);
        return index;
    }
}
