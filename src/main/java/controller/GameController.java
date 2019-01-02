package controller;

import model.GameBoard;
import model.Cup;
import model.Player;
import model.squareTypes.Square;
import ui.Abstract_UI;
import ui.GUI_Boundary;
//import ui.TUI;

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
    private Abstract_UI ui;         //Instant of abstract class Abstract_UI
    private boolean isOn;           //Boolean that determines if the game is active

    /**
     * Constructor of GameController class
     */
    public GameController() {
        ui = new GUI_Boundary();

        int numberOfPlayers;
        do {
            numberOfPlayers = ui.askForNumberOfPlayers();
        } while(numberOfPlayers == -1);
        players = new Player[numberOfPlayers];

//        this.gameBoard = new GameBoard(24, players);
        this.gameBoard = new GameBoard(this, ui);
        this.cup = new Cup();

        String[] names = ui.askForNames(players.length);

        for(int i=0; i<players.length; i++){
            players[i] = new Player(names[i], gameBoard, cup);
        }
        ui.setPlayers(names, numberOfPlayers);

        currPlayer = players[0];

        isOn = true;
    }

    public void run(){
        ui.setGameController(this);

        while(isOn){
            for (Player player: players) { //TODO KNA: Either fix this to standard for-loop or be ready to defend it since it doesn't hold up to "inititiate-condition-afterthought"/"index-condition-increment"
                currPlayer = player;

                if(ui.askToTakeTurn()){
                    player.takeTurn();
                    ui.showCurrentDiesResult();
                    ui.showScenario();
                }
                ui.updateBoardView();
                if(loserFound()){
                    isOn = false;
                    break;
                }
            }
        }
        ui.showFinalResult();
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
//     */
//    public GameController(int numberOfPlayers) {
//        ui = new TUI();
//        players = new Player[numberOfPlayers];
////        this.gameBoard = new GameBoard(24, players);
//        this.gameBoard = new GameBoard(24, this);
//        this.cup = new Cup();
//
//        for(int i=0; i<players.length; i++){
//            players[i] = new Player("", gameBoard, cup);
//        }
//        currPlayer = players[0];
//        isOn = true;
//    }

    /**
     * Test method, might be able to be fixed by new constructor
     * @return
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