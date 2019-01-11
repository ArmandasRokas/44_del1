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
        //TODO fix prices
        squareList [0] = new StartSquare("Start");
        squareList [1] = new StreetSquare ("Rødovrevej", new int[]{2, 10, 30, 90, 160, 250}, 60, 0, 1, gui_boundary);
   //     squareList [2] = new ChanceSquare("Prøv lykken", 0, gui_boundary);
        squareList [3] = new StreetSquare("Hvidovrevej", new int []{4, 20, 60, 180, 320, 540}, 60, 0, 3, gui_boundary);
  //      squareList [4] = new Tax("Indkomstskat", 200, 10, gui_boundary);
  //      squareList [5] = new TravelSquare("Øresund",  new int []{25, 50, 100, 200},200, gui_boundary);
        squareList [6] = new StreetSquare("Roskildevej", new int []{6, 30, 90, 270, 400, 550}, 100, 1, 6, gui_boundary);
  //      squareList [7] = new ChanceSquare("Prøv lykken", 1, gui_boundary);
        squareList [8] = new StreetSquare("Valby Langgade", new int []{6, 30, 90, 270, 400, 550}, 100, 1, 8, gui_boundary);
        squareList [9] = new StreetSquare("Allégade", new int []{8, 40, 100, 300, 450, 600}, 120, 1, 9, gui_boundary);
 //       squareList [10] = new Parking("'I fængslet'", gui_boundary);
        squareList [11] = new StreetSquare("Frederiksberg Allé", new int []{10, 50, 150, 450, 625, 750}, 140, 2, 11, gui_boundary);
 //      squareList [12] = new Company("Tuborg", 150, gui_boundary);
        squareList [13] = new StreetSquare("Bülowsvej", new int []{10, 50, 150, 450, 625, 750}, 140, 2, 13, gui_boundary);
        squareList [14] = new StreetSquare("Gl. Kongevej", new int []{12, 60, 180, 500, 700, 900}, 160, 2, 14, gui_boundary);
  //      squareList [15] = new TravelSquare("D.F.D.S", new int []{25, 50, 100, 200},200, gui_boundary);
        squareList [16] = new StreetSquare("Bernstoffsvej", new int []{14, 70, 200, 550, 750, 950}, 180, 3, 16, gui_boundary);
 //       squareList [17] = new ChanceSquare("Prøv lykken", 2, gui_boundary);
        squareList [18] = new StreetSquare("Hellerupvej", new int []{14, 70, 200, 550, 750, 950}, 180, 3, 18, gui_boundary);
        squareList [19] = new StreetSquare("Strandvejen", new int []{16, 80, 220, 600, 800, 1000}, 200, 3, 19, gui_boundary);
  //      squareList [20] = new Parking("'Parkering'", gui_boundary);
        squareList [21] = new StreetSquare("Trianglen", new int []{18, 90, 250, 700, 875, 1050}, 220, 4, 21, gui_boundary);
  //      squareList [22] = new ChanceSquare("Prøv lykken", 3, gui_boundary);
        squareList [23] = new StreetSquare("Østerbrogade", new int []{18, 90, 250, 700, 875, 1050}, 220, 4, 23, gui_boundary);
        squareList [24] = new StreetSquare("Grønningen", new int []{20, 100, 300, 750, 925, 1100}, 240, 4, 24, gui_boundary);
  //      squareList [25] = new TravelSquare("Ø.K.", new int []{25, 50, 100, 200},200, gui_boundary);
        squareList [26] = new StreetSquare("Bredgade", new int []{22, 110, 330, 800, 975, 1150}, 260, 5, 26, gui_boundary);
        squareList [27] = new StreetSquare("Kgs. Nytorv", new int []{22, 110, 330, 800, 975, 1050}, 260, 5, 27, gui_boundary);
  //      squareList [28] = new Company("Carlsberg", 150, gui_boundary);
        squareList [29] = new StreetSquare("Østergade", new int []{22, 120, 360, 850, 1025, 1200}, 280, 5, 29, gui_boundary);
  //      squareList [30] = new Jail("De fængsles", gui_boundary);
        squareList [31] = new StreetSquare("Amagertorv", new int []{26, 130, 390, 900, 1100, 1275}, 300, 6, 31, gui_boundary);
        squareList [32] = new StreetSquare("Vimmelskaftet", new int []{26, 130, 390, 900, 1100, 1275}, 300, 6, 32, gui_boundary);
  //      squareList [33] = new ChanceSquare("Prøv lykken", 4, gui_boundary);
        squareList [34] = new StreetSquare("Nygade", new int []{28, 150, 450, 1000, 1200, 1400}, 320, 6, 34, gui_boundary);
 //       squareList [35] = new TravelSquare("D/S Bornholm 1866", new int []{25, 50, 100, 200},200, gui_boundary);
 //       squareList [36] = new ChanceSquare("Prøv lykken", 5, gui_boundary);
        squareList [37] = new StreetSquare("Frederiksberggade", new int []{35, 175, 500, 1100, 1300 ,1500}, 350, 7, 37, gui_boundary);
   //     squareList [38] = new Tax("Statsskat", 100, 0, gui_boundary);
        squareList [39] = new StreetSquare("Rådhuspladsen", new int[]{50, 200, 600, 1400, 1700, 2000}, 400, 7, 39, gui_boundary);

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