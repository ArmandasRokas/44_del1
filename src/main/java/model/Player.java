package model;

import model.squareTypes.PropertySquare;
import model.squareTypes.Square;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Player class and all if its fields and methods
 * Class to represent a single player throughout the gameController
 */
public class Player {
    private String name;
    private Account account;
    private int currPosition;
    private ArrayList<PropertySquare> squaresOwned;
    private GameBoard gameBoard;
    private Cup cup;
    private int outOfJailCard;

    /**
     * Constructor for Player
     *
     * @param number    Player number
     */
    public Player(String number, GameBoard gameBoard, Cup cup){
        this.cup = cup;
        this.gameBoard = gameBoard;
        this.account = new Account();
        this.name = number;
        currPosition = 0;
        outOfJailCard = 0;
        squaresOwned = new ArrayList<>();
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

    public String getName(){
        return name;
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
        int latestPosition = currPosition;
        cup.roll();
        int currentRollScore = cup.getCurrentRollScore();
        movePlayer(currentRollScore);

        int cashStartIncome = 2;
        if(latestPosition>currPosition){  // checks if player completed one round
            this.addToCash(cashStartIncome);
        }

        Square square = gameBoard.getSquare(this.currPosition);
        square.landedOn(this);
    }

    public void movePlayer(int squaresNumberToMove){

        int newPosition = gameBoard.getNewPosition(currPosition,squaresNumberToMove);
        this.updateCurrPosition(newPosition);
    }

    public void moveToSquare(int squareNumber){

        this.updateCurrPosition(squareNumber);
        Square square = gameBoard.getSquare(this.currPosition);
        square.landedOn(this);
    }

    public int getTotalSquareOwned(){
        return squaresOwned.size();
    }

    public void giveOutOfJailCard() {
        this.outOfJailCard++;
    }

    public String toString(){
        int position = currPosition + 1;
        return "" + name + " is on " + position + " of " + "24 has: " + getTotalCash() + "M";
    }
}
