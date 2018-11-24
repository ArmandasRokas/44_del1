package model;

import util.GameTool;

import java.io.IOException;
import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the Board class and all of its fields and methods
 * Class to represent the playing board and to contain and arrange the squares players can land on
 */
public class Board {
    private Square squareList[];
    private Square currSquare;
    private ArrayList<String> scenerioStrings;

    /**
     * Constructor for Board
     *
     * @param squareAmount  Amounts of square needed to fill the board for a specific game
     */
    public Board(int squareAmount) {
        squareList = new Square[squareAmount];
        loadContent();
        this.setBoard();
    }

    /**
     * This constructor is for testing purposes!
     */
    public Board(int squareAmount, boolean isTest){
        squareList = new Square[squareAmount];
    }

    /**
     * Loads the scenario descriptions of the squares through a hardcoded filename
     */
    private void loadContent(){
        try {
            scenerioStrings = GameTool.readFromFile("EN_scenarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates instances of Square to fill the game board and puts them into a list for containment
     */
    private void setBoard() {
        squareList[0] = new Square(scenerioStrings.get(1),250);
        squareList[1] = new Square(scenerioStrings.get(2),-100);
        squareList[2] = new Square(scenerioStrings.get(3),100);
        squareList[3] = new Square(scenerioStrings.get(4),-20);
        squareList[4] = new Square(scenerioStrings.get(5),180);
        squareList[5] = new Square(scenerioStrings.get(6),0);
        squareList[6] = new Square(scenerioStrings.get(7),-70);
        squareList[7] = new Square(scenerioStrings.get(8),60);
        squareList[8] = new Square(scenerioStrings.get(9),-80, true);
        squareList[9] = new Square(scenerioStrings.get(10),-50);
        squareList[10] = new Square(scenerioStrings.get(11),650);
    }

    /**
     * Updates the position of the current player after he have rolled the dices
     *
     * @param totalEyes Number of eyes on the dices the player have rolled
     */
    public void updateCurrSquare(int totalEyes){
        switch (totalEyes){
            case 2:
                currSquare = squareList[0];
                break;
            case 3:
                currSquare = squareList[1];
                break;
            case 4:
                currSquare = squareList[2];
                break;
            case 5:
                currSquare = squareList[3];
                break;
            case 6:
                currSquare = squareList[4];
                break;
            case 7:
                currSquare = squareList[5];
                break;
            case 8:
                currSquare = squareList[6];
                break;
            case 9:
                currSquare = squareList[7];
                break;
            case 10:
                currSquare = squareList[8];
                break;
            case 11:
                currSquare = squareList[9];
                break;
            case 12:
                currSquare = squareList[10];
                break;
            default:
                currSquare = null;
        }
    }

    /**
     * Controls if the Square is meant to give the player an extra turn
     *
     * @return  Boolean which is true if the player is to get an extra turn, else it is false
     */
    public boolean checkExtraTurn() {
        return currSquare.checkExtraTurn();
    }

    /**
     * Get methods of Board class
     */
    public String getCurrScenerio(){
        return currSquare.getScenario();
    }
    public int getCurrCashInfluence(){
        return currSquare.getCashInfluence();
    }

    /**
     * Calculates the new position of a player after a roll, considering that the player moves in a circle.
     *
     * @param currPosition The players position from last turn.
     * @param totalEye The die's eye count.
     * @return Returns the new position, after dice throw.
     */

    public int getNewPosition(int currPosition, int totalEye){
        int newPosition;
        int squareListLength = squareList.length;


        if (totalEye >= (squareListLength - currPosition)) {
            newPosition = totalEye - (squareListLength - currPosition);
        } else {
            newPosition = currPosition + totalEye;
        }
        return newPosition;
    }

}