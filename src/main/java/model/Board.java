package model;

import controller.Game;
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
    private ArrayList<String> scenerioStrings;

    /**
     * Constructor for Board
     *
     * @param squareAmount  Amounts of square needed to fill the board for a specific game
     */
//    public Board(int squareAmount, Player[] players) {
    public Board(int squareAmount, Game game) {
        squareList = new Square[squareAmount];
//        loadContent();
        this.setBoard(game);
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
    //FixMe KNA: Didn't delete since I think it's an interesting thing to add to the program, if time is there
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
//    private void setBoard(Player[] players) {
    private void setBoard(Game game) {
        squareList[0] = new StartSquare("Start");
        squareList[1] = new PropertySquare("BurgerBar",1,1,"Brown");
        squareList[2] = new PropertySquare("PizzaHouse",1,1,"Brown");
        squareList[3] = new ChanceSquare("Chance", game.getPlayers(), this);
        squareList[4] = new PropertySquare("CandyShop",1,1,"Teal");
        squareList[5] = new PropertySquare("IceCreamShop",1,1,"Teal");
        squareList[6] = new JailSquare("Prison");
        squareList[7] = new PropertySquare("Museum",2,2,"Purple");
        squareList[8] = new PropertySquare("Libary",2,2,"Purple");
//        squareList[9] = new ChanceSquare("Chance", players, this);
        squareList[9] = squareList[3];
        squareList[10] = new PropertySquare("SkaterPark",2,2,"White");
        squareList[11] = new PropertySquare("SwimmingPool",2,2,"White");
        squareList[12] = new ParkingSquare("Free Parking");
        squareList[13] = new PropertySquare("GameHall",3,3,"Red");
        squareList[14] = new PropertySquare("Cinema",3,3,"Red");
//        squareList[15] = new ChanceSquare("Chance", players, this);
        squareList[15] = squareList[3];
        squareList[16] = new PropertySquare("ToyShop",3,3,"Yellow");
        squareList[17] = new PropertySquare("PetShop",3,3,"Yellow");
        squareList[18] = new ToJailSquare("To Prison", this);
        squareList[19] = new PropertySquare("BowlingHall",4,4,"Green");
        squareList[20] = new PropertySquare("Zoo",4,4,"Green");
//        squareList[21] = new ChanceSquare("Chance", players, this);
        squareList[21] = squareList[3];
        squareList[22] = new PropertySquare("WaterPark",5,5,"Blue");
        squareList[23] = new PropertySquare("TheBeach",5,5,"Blue");

        setPropertySquareSiblings();
    }

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
}