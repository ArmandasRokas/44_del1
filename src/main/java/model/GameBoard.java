package model;

import controller.GameController;
import model.squareTypes.*;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the GameBoard class and all of its fields and methods
 * Class to represent the playing board and to contain and arrange the squares players can land on
 */
public class GameBoard {
    private Square squareList[];                //List of squares

    /**
     * Constructor for GameBoard
     *
     * @param squareAmount      Amounts of square needed to fill the board for a specific gameController
     * @param gameController    Reference to gameController
     */
    public GameBoard(int squareAmount, GameController gameController) {
        squareList = new Square[squareAmount];
        this.setBoard(gameController);
    }

    /**
     * Creates instances of Square to fill the gameController board and puts them into a list for containment
     *
     * @param gameController    Reference to current used GameController
     */
    private void setBoard(GameController gameController) {
        ChanceSquare CSReference = new ChanceSquare("Chance", gameController.getPlayers(), this);

        squareList[0] = new StartSquare("Start");
        squareList[1] = new PropertySquare("BurgerBar",1,1,"Brown");
        squareList[2] = new PropertySquare("PizzaHouse",1,1,"Brown");
        squareList[3] = CSReference;
        squareList[4] = new PropertySquare("CandyShop",1,1,"Teal");
        squareList[5] = new PropertySquare("IceCreamShop",1,1,"Teal");
        squareList[6] = new JailSquare("Prison");
        squareList[7] = new PropertySquare("Museum",2,2,"Purple");
        squareList[8] = new PropertySquare("Libary",2,2,"Purple");
        squareList[9] = CSReference;
        squareList[10] = new PropertySquare("SkaterPark",2,2,"White");
        squareList[11] = new PropertySquare("SwimmingPool",2,2,"White");
        squareList[12] = new ParkingSquare("Free Parking");
        squareList[13] = new PropertySquare("GameHall",3,3,"Red");
        squareList[14] = new PropertySquare("Cinema",3,3,"Red");
        squareList[15] = CSReference;
        squareList[16] = new PropertySquare("ToyShop",3,3,"Yellow");
        squareList[17] = new PropertySquare("PetShop",3,3,"Yellow");
        squareList[18] = new ToJailSquare("To Prison", this);
        squareList[19] = new PropertySquare("BowlingHall",4,4,"Green");
        squareList[20] = new PropertySquare("Zoo",4,4,"Green");
        squareList[21] = CSReference;
        squareList[22] = new PropertySquare("WaterPark",5,5,"Blue");
        squareList[23] = new PropertySquare("TheBeach",5,5,"Blue");

        setPropertySquareSiblings();
    }

    /**
     * Part of the setup of Board. Links the PropertySquares with their partners by comparings their colors
     */
    //TODO: Optimize, a property can only have one square atm and might only have to check for +2 and -2 of current index instead of whole list
    private void setPropertySquareSiblings() {
        for(int i = 0 ; i < squareList.length ; i++) {

            if(squareList[i] instanceof PropertySquare) {
                PropertySquare ps = (PropertySquare)squareList[i];
                String color = ps.getColor();

                for(Square square : squareList) {
                    if(square instanceof PropertySquare) {
                        PropertySquare ps2 = (PropertySquare)squareList[i];

                        if(ps2.getColor().equals(color)) {
                            ps2.setSiblingSquare(ps);
                        }
                    }
                }
            }
        }
    }

    /**
     * Finds the wanted square with a reference of its name
     *
     * @param name  Name of the wanted squares
     * @return      Instance of Square
     */
    public int findSquareByName(String name) {
        int res = 0;
        boolean found = false;

        for(int i = 0 ; i < squareList.length && !found ; i++) {
            if(squareList[i].getScenario().equals(name)) {
                res = i;
                found = true;
            }
        }
        return res;
    }

    /**
     * Calculates the new position of a player after a roll, considering that the player moves in a circle.
     *
     * @param currPosition  The players position from last turn.
     * @param totalEye      The die's eye count.
     * @return              The new position, after dice throw.
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

    /**
     * Returns instance of Square with use of a reference of its index
     *
     * @param index Index of Square on the list of squares
     * @return      Instance of Square
     */
    public Square getSquare(int index){
        return squareList[index];
    }


    //----------------------Methods for tests!------------------------

    /**
     * Test constructor to get an instance of GameBoard without the need of an instance of GameController
     */
    public GameBoard(int squareAmount, boolean isTest){
        squareList = new Square[squareAmount];
    }
}