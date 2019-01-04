package controller;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import model.GameBoard;
import model.Cup;
import model.Player;
import model.squareTypes.PropertySquare;
import model.squareTypes.Square;
import ui.Abstract_UI;
import ui.TUI;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines GameController and all its fields and methods
 * Represents the logic of the gameController throughout it. Is to act between the inputs from the ui layer and the domain layer
 * according to this logic
 */
public class GameController {
    private Player currPlayer;      //Instances of Player
    private Player[] players;       //Array of players
    private GameBoard gameBoard;    //Instance of GameBoard
    private Cup cup;                //Instance of Cup
    private boolean isOn;           //Boolean that determines if the game is active
    private GameLogic logic = new GameLogic();
    private GUI gui;

    /**
     * Constructor of GameController class
     */
    public GameController() {
        gui = new GUI();


//        this.gameBoard = new GameBoard(24, players);
        this.gameBoard = new GameBoard(24, this);
        this.cup = new Cup();


        setGUIBoard();

        int numberOfPlayers;
        do {
            numberOfPlayers = gui.getUserInteger("Vælg antal spillere (3-6)",3 ,6);
        } while(!logic.controlPlayerCount(numberOfPlayers));
        players = new Player[numberOfPlayers];


        for(int i=0; i<players.length; i++){
            String playerName = gui.getUserString("Skriv navn for spiller nr. " + (i+1)); //TODO Kontrol af at de ikke må have samme navn, da GUI ikke tager hensyn til det
            players[i] = new Player(playerName, gameBoard, cup);
            GUI_Player guiPlayer = new GUI_Player(players[i].getName(), players[i].getTotalCash());
            gui.addPlayer(guiPlayer);
            players[i].setPiece(guiPlayer);
            gui.getFields()[0].setCar(players[i].getPiece(), true);
        }


        currPlayer = players[0];

        isOn = true;
    }

    private void setGUIBoard() {
        Square[] gameSquares = gameBoard.getSquareList();
        GUI_Field[] guiSquares = gui.getFields();

        //TODO Skal lige tage hensyn til de forskellige typer felter
        for(int i = 0 ; i < gameSquares.length ; i++) {
            if(gameSquares[i] instanceof PropertySquare) {
                guiSquares[i].setTitle(gameSquares[i].getScenario());
                guiSquares[i].setBackGroundColor(((PropertySquare)gameSquares[i]).getColor());
                guiSquares[i].setSubText("Pris: " + Integer.toString(((PropertySquare)gameSquares[i]).getPrice()));

            }
        }
    }

    public void run(){
//        gui.setGameController(this);

        while(isOn){
            for (Player player: players) {
                currPlayer = player;

                if(!loserFound()) {
                    gui.getUserButtonPressed("Det er " + currPlayer.getName() + "'s tur. Tryk for at kaste med terningen", "Kast");
                    int oldPos = currPlayer.getCurrPosition();
                    currPlayer.takeTurn();
                    gui.getFields()[oldPos].setCar(currPlayer.getPiece(), false);
                    gui.getFields()[currPlayer.getCurrPosition()].setCar(currPlayer.getPiece(), true);
                    gui.setDice(cup.getFirstDie(), cup.getSecondDie());

//                    gui.showScenario();
                }



//                if(gui.askToTakeTurn()){
//                    player.takeTurn();
//                    gui.showCurrentDiesResult();
//                    gui.showScenario();
//                }
//                gui.updateBoardView();
//                if(loserFound()){
//                    isOn = false;
//                    break;
//                }
            }
        }
//        gui.showFinalResult();
    }

    /**
     * Method to control if a loser has been found
     *
     * @return  boolean which is true if a loser has been found
     */
    //TODO skal overvejes til at flytte metodens logik til Player class og laves om til taber fundet
    public boolean loserFound() {
        boolean res = false;
        if(currPlayer.getTotalCash() <= 0) {
            res = true;
        }
        return res;
    }

    /**
     * Get methods to get instance of current player
     *
     * @return  Instance of Player
     */
    public String getCurrPlayerName(){
        return currPlayer.getName();
    }

    public Square getCurrSquare(){
        return gameBoard.getSquare(currPlayer.getCurrPosition());
    }

    /**
     * Looks through the players for the one with the highest balance on and returns them as the winner
     *
     * @return  Instance of Player
     */
    //TODO skal implementeres ved uafgjort spil -> tæl ejendomsværdien op
    public String getWinnerName(){
        Player tempWinner = players[0];

        for(int i = 1; i<players.length ; i++){
            if (tempWinner.getTotalCash() < players[i].getTotalCash()){
                tempWinner = players[i];
            }
        }
        return tempWinner.getName();
    }

    //-------------METHODS FOR TESTS BENEATH-----------------

    /**
     * Test constructor, only used for tests!
     * Used by: ChanceSquareTest
     */
    public GameController(int numberOfPlayers) {
//        ui = new TUI();
        players = new Player[numberOfPlayers];
//        this.gameBoard = new GameBoard(24, players);
        this.gameBoard = new GameBoard(24, this);
        this.cup = new Cup();

        for(int i=0; i<players.length; i++){
            players[i] = new Player("", gameBoard, cup);
        }
        currPlayer = players[0];
        isOn = true;
    }

    /**
     * Test method, might be able to be fixed by new constructor
     */
    public Player[] getPlayers(){
        return players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getCurrentDiesTotal(){
        return cup.getCurrentRollScore();
    }
}