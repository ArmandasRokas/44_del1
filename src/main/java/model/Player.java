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
    private int outOfJailCard; //TODO Implement as part of "ToJailSquare"-use

    /**
     * Constructor of Player
     *
     * @param name      Players name
     * @param gameBoard Reference to instance of GameBoard
     * @param cup       Reference to instance of Cup
     */
    public Player(String name, GameBoard gameBoard, Cup cup){
        this.cup = cup;
        this.gameBoard = gameBoard;
        this.account = new Account();
        this.name = name;
        currPosition = 0;
        outOfJailCard = 0;
        squaresOwned = new ArrayList<>();
    }


    /**
     * Method to go through a whole turn of the player
     */
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

    /**
     * Moves the player a selected amount of squares on the board.
     *
     * @param squaresNumberToMove   Amount of squares Player is to be moved
     */
    public void movePlayer(int squaresNumberToMove){
        int newPosition = gameBoard.getNewPosition(currPosition,squaresNumberToMove);
        this.updateCurrPosition(newPosition);
    }

    /**
     * Moves the player to a specific square with the use of the square index
     *
     * @param squareNumber  Index of the instance of Square, Player is to be moved to
     */
    public void moveToSquare(int squareNumber){
        this.updateCurrPosition(squareNumber);
        Square square = gameBoard.getSquare(this.currPosition);
        square.landedOn(this);
    }

    /**
     * toString method of Player class. Is to print: name, position and current cash balance
     * @return
     */
    public String toString(){
        int position = currPosition + 1;
        return "" + name + " is on " + position + " of " + "24 has: " + getTotalCash() + "M";
    }

    /**
     * Get method of the players name
     *
     * @return  Name of Player
     */
    public String getName(){
        return name;
    }

    /**
     * Updates the position of the player
     *
     * @param position
     */
    public void updateCurrPosition(int position) {
        this.currPosition = position;
    }
    /**
     * Get method for current location on Player
     * @return
     */
    public int getCurrPosition() {
        return currPosition;
    }

    /**
     * Method that adds cash unto the current balance of instance of Player. Deducts if negative amount is used.
     *
     * @param cashInfluence Amount the balance is to be influenced by
     */
    public void addToCash(int cashInfluence){
        this.account.addToCash(cashInfluence);
    }
    /**
     * Get method for current cash balance of Player
     *
     * @return  Current balance of Player
     */
    public int getTotalCash() {
        return account.getTotalCash();
    }

    /**
     * Notes that the player is holding one more "Out of 'Get out of jail'-Card"
     */
    public void giveOutOfJailCard() {
        this.outOfJailCard++;
    }

    /**
     * Adds a reference to a bought square to Players list of owned properties
     *
     * @param square    Instance of Square
     */
    public void addOwnedSquare(PropertySquare square){
        squaresOwned.add(square);
    }
    /**
     * Retrieves list of owned squares of Player
     *
     * @return  List of Square references
     */
    public int getTotalSquareOwned(){
        return squaresOwned.size();
    }
}
