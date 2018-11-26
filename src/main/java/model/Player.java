package model;

import model.squareTypes.PropertySquare;
import model.squareTypes.Square;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Player class and all if its fields and methods
 * Class to represent a single player throughout the game
 */
public class Player {
    private String numberOfPlayers;
    private Account account;
    private int currPosition;
    private ArrayList<PropertySquare> squaresOwned;
    private Board board;
    private Cup cup;

    /**
     * Constructor for Player
     *
     * @param number    Player number
     */
    public Player(String number, Board board, Cup cup){
        this.cup = cup;
        this.board = board;
        this.account = new Account();
        this.numberOfPlayers = number;
        currPosition = 0;
    }

    /**
     * Method to add cash unto the account of instance of Player
     *
     * @param cashInfluence
     */
    public void addToCash(int cashInfluence){
        this.account.addToCash(cashInfluence);
    }

    /**
     * Get methods of Player class.
     */
    public int getTotalCash() {
        return account.getTotalCash();
    }
    public String getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void updateCurrPosition(int position) {
        this.currPosition = position;
    }

    public void addOwnedSquare(PropertySquare square){
        squaresOwned.add(square);
    }


    public void takeTurn() {

        cup.roll();
        movePlayer(cup.getCurrentRollScore());
        Square square = board.getSquare(this.currPosition);
        square.landedOn(this);

    }

    public void movePlayer(int squaresNumberToMove){

        int newPosition = board.getNewPosition(currPosition,squaresNumberToMove);
        this.updateCurrPosition(newPosition);
    }

    public void movePlayerToSquare(int squareNumber){

        this.updateCurrPosition(squareNumber);
        Square square = board.getSquare(this.currPosition);
        square.landedOn(this);
    }

    public int getTotalSquareOwned(){
        return squaresOwned.size();
    }

}
