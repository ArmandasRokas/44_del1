package model;

import model.squareTypes.*;
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
        squareList[0] = new StartSquare("Start");
        squareList[1] = new PropertySquare("BurgerBar",1,1,"Brown");
        squareList[2] = new PropertySquare("PizzaHouse",1,1,"Brown");
        squareList[3] = new ChanceSquare("Chance");
        squareList[4] = new PropertySquare("CandyShop",1,1,"Teal");
        squareList[5] = new PropertySquare("IceCreamShop",1,1,"Teal");
        squareList[6] = new PrisonSquare("Prison");
        squareList[7] = new PropertySquare("Museum",2,2,"Purple");
        squareList[8] = new PropertySquare("Libary",2,2,"Purple");
        squareList[9] = new ChanceSquare("Chance");
        squareList[10] = new PropertySquare("SkaterPark",2,2,"White");
        squareList[11] = new PropertySquare("SwimmingPool",2,2,"White");
        squareList[12] = new ParkingSquare("Free Parking");
        squareList[13] = new PropertySquare("GameHall",3,3,"Red");
        squareList[14] = new PropertySquare("Cinema",3,3,"Red");
        squareList[15] = new ChanceSquare("Chance");
        squareList[16] = new PropertySquare("ToyShop",3,3,"Yellow");
        squareList[17] = new PropertySquare("PetShop",3,3,"Yellow");
        squareList[18] = new ToPrisonSquare("To Prison");
        squareList[19] = new PropertySquare("BowlingHall",4,4,"Green");
        squareList[20] = new PropertySquare("Zoo",4,4,"Green");
        squareList[21] = new ChanceSquare("Chance");
        squareList[22] = new PropertySquare("WaterPark",5,5,"Blue");
        squareList[23] = new PropertySquare("TheBeach",5,5,"Blue");
    }

    /**
     * Updates the position of the current player after he have rolled the dices
     *
     * @param totalEyes Number of eyes on the dices the player have rolled
     */
//    public void updateCurrSquare(int totalEyes){
//        switch (totalEyes){
//            case 2:
//                currSquare = squareList[0];
//                break;
//            case 3:
//                currSquare = squareList[1];
//                break;
//            case 4:
//                currSquare = squareList[2];
//                break;
//            case 5:
//                currSquare = squareList[3];
//                break;
//            case 6:
//                currSquare = squareList[4];
//                break;
//            case 7:
//                currSquare = squareList[5];
//                break;
//            case 8:
//                currSquare = squareList[6];
//                break;
//            case 9:
//                currSquare = squareList[7];
//                break;
//            case 10:
//                currSquare = squareList[8];
//                break;
//            case 11:
//                currSquare = squareList[9];
//                break;
//            case 12:
//                currSquare = squareList[10];
//                break;
//            default:
//                currSquare = null;
//        }
//    }



    /**
     * Get methods of Board class
     */
    public String getCurrScenerio(){
        return currSquare.getScenario();
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

    public Square getSquare(int index){
        return squareList[index];
    }

}