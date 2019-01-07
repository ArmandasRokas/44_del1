package model;

import controller.GameController;
import model.squareTypes.*;
import ui.Abstract_UI;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the GameBoard class and all of its fields and methods
 * Class to represent the playing board and to contain and arrange the squares players can land on
 */
public class GameBoard {
    private Square[] squareList;                //List of squares

    /**
     * Constructor for GameBoard
     *
     * @param squareAmount      Amounts of square needed to fill the board for a specific gameController
     * @param gameController    Reference to gameController
     */
    public GameBoard(GameController gameController, Abstract_UI gui_boundary) {
        squareList = new Square[40];
        this.setBoard(gameController, gui_boundary);
}

    /**
     * Creates instances of Square to fill the gameController board and puts them into a list for containment
     *
     * @param gameController    Reference to current used GameController
     */
    private void setBoard(GameController gameController, Abstract_UI gui_boundary ) {
        ChanceSquare CSReference = new ChanceSquare("Chance", gameController.getPlayers(), this);

        squareList [0] = new StartSquare("Start");
        squareList [1] = new PropertySquare("Rødovrevej", new int[]{50, 250, 750, 2250, 4000, 6000}, 1200, 0, 1, gui_boundary);
   //     squareList [2] = new ChanceSquare("Prøv lykken", 0, gui_boundary);
        squareList [2] = new PropertySquare("Hvidovrevej", new int []{50, 250, 750, 2250, 4000, 6000}, 1200, 0, 3, gui_boundary);
  //      squareList [3] = new PropertySquare("Hvidovrevej", new int []{50, 250, 750, 2250, 4000, 6000}, 1200, 0, 3, gui_boundary);
  //      squareList [4] = new Tax("Indkomstskat", 4000, 10, gui_boundary);
  //      squareList [5] = new Fleet("Helsingør/Helsingborg",  new int []{500, 1000, 2000, 4000},4000, gui_boundary);
        squareList [6] = new PropertySquare("Roskildevej", new int []{100, 600, 1800, 5400, 8000, 11000}, 2000, 1, 6, gui_boundary);
  //      squareList [7] = new ChanceSquare("Prøv lykken", 1, gui_boundary);
        squareList [8] = new PropertySquare("Valby Langgade", new int []{100, 600, 1800, 5400, 8000, 11000}, 2000, 1, 8, gui_boundary);
        squareList [9] = new PropertySquare("Allégade", new int []{150, 800, 2000, 6000, 9000, 12000}, 2400, 1, 9, gui_boundary);
 //       squareList [10] = new Parking("'I fængslet'", gui_boundary);
        squareList [11] = new PropertySquare("Frederiksberg Allé", new int []{200, 1000, 3000, 9000, 12500, 15000}, 2800, 2, 11, gui_boundary);
 //      squareList [12] = new Brewery("Tuborg Squash", 3000, gui_boundary);
        squareList [13] = new PropertySquare("Bülowsvej", new int []{200, 1000, 3000, 9000, 12500, 15000}, 2800, 2, 13, gui_boundary);
        squareList [14] = new PropertySquare("Gl. Kongevej", new int []{250, 1250, 3750, 10000, 14000, 18000}, 3200, 2, 14, gui_boundary);
  //      squareList [15] = new Fleet("Mols-linien", new int []{500, 1000, 2000, 4000},4000, gui_boundary);
        squareList [16] = new PropertySquare("Bernstoffsvej", new int []{300, 1400, 4000, 11000, 15000, 19000}, 3600, 3, 16, gui_boundary);
 //       squareList [17] = new ChanceSquare("Prøv lykken", 2, gui_boundary);
        squareList [18] = new PropertySquare("Hellerupvej", new int []{300, 1400, 4000, 11000, 15000, 19000}, 3600, 3, 18, gui_boundary);
        squareList [19] = new PropertySquare("Strandvejen", new int []{350, 1600, 4400, 12000, 16000, 20000}, 4000, 3, 19, gui_boundary);
  //      squareList [20] = new Parking("'Parkering'", gui_boundary);
        squareList [21] = new PropertySquare("Trianglen", new int []{350, 1800, 5000, 14000, 17500, 21000}, 4400, 4, 21, gui_boundary);
  //      squareList [22] = new ChanceSquare("Prøv lykken", 3, gui_boundary);
        squareList [23] = new PropertySquare("Østerbrogade", new int []{350, 1800, 5000, 14000, 17500, 21000}, 4400, 4, 23, gui_boundary);
        squareList [24] = new PropertySquare("Grønningen", new int []{400, 2000, 6000, 15000, 18500, 22000}, 4800, 4, 24, gui_boundary);
  //      squareList [25] = new Fleet("Gedser/Rostock", new int []{500, 1000, 2000, 4000},4000, gui_boundary);
        squareList [26] = new PropertySquare("Bredgade", new int []{450, 2200, 6600, 16000, 19500, 23000}, 5200, 5, 26, gui_boundary);
        squareList [27] = new PropertySquare("Kgs. Nytorv", new int []{450, 2200, 6600, 16000, 19500, 23000}, 5200, 5, 27, gui_boundary);
  //      squareList [28] = new Brewery("Coca Cola", 3000, gui_boundary);
        squareList [29] = new PropertySquare("Østergade", new int []{500, 2400, 7200, 17000, 20500, 24000}, 5600, 5, 29, gui_boundary);
  //      squareList [30] = new Jail("De fængsles", gui_boundary);
        squareList [31] = new PropertySquare("Amagertorv", new int []{550, 2600, 7800, 18000, 22000, 25000}, 6000, 6, 31, gui_boundary);
        squareList [32] = new PropertySquare("Vimmelskaftet", new int []{550, 2600, 7800, 18000, 22000, 25000}, 6000, 6, 32, gui_boundary);
  //      squareList [33] = new ChanceSquare("Prøv lykken", 4, gui_boundary);
        squareList [34] = new PropertySquare("Nygade", new int []{600, 3000, 9000, 20000, 24000, 28000}, 6400, 6, 34, gui_boundary);
 //       squareList [35] = new Fleet("Rødby/Puttgarten", new int []{500, 1000, 2000, 4000},4000, gui_boundary);
 //       squareList [36] = new ChanceSquare("Prøv lykken", 5, gui_boundary);
        squareList [37] = new PropertySquare("Frederiksberggade", new int []{700, 3500, 10000, 22000, 26000 ,30000}, 7000, 7, 37, gui_boundary);
   //     squareList [38] = new Tax("Statsskat", 2000, 0, gui_boundary);
        squareList [39] = new PropertySquare("Rådhuspladsen", new int[]{1000, 4000, 12000, 28000, 34000, 40000}, 8000, 7, 39, gui_boundary);

        setPropertySquareSiblings();
    }

    /**
     * Part of the setup of Board. Links the PropertySquares with their partners by comparings their colors
     */
    //TODO: Optimize, a property can only have one square atm and might only have to check for +2 and -2 of current index instead of whole list
    private void setPropertySquareSiblings() {
        for(int i = 0 ; i < squareList.length ; i++) {

            if(squareList[i] instanceof PropertySquare) {
                PropertySquare ps = (PropertySquare) squareList[i];
                int groupID = ps.getGroupID();

                for(Square square : squareList) {
                    if(square instanceof PropertySquare && !square.equals(ps)) {
                        PropertySquare ps2 = (PropertySquare) square;

                        if(ps2.getGroupID() == groupID) {
                            ps.setSiblingSquare(ps2);
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
            if(squareList[i].toString().equals(name)) {
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

    public Square[] getSquareList(){
        return squareList;
    }

    public GameBoard(GameController gameController, Abstract_UI ui, boolean isTest){
        squareList = new Square[40];
        setBoard(gameController, ui);

    }
}