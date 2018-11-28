package controller;

import model.Board;
import model.Cup;
import model.Die;
import model.Player;
import model.squareTypes.Square;
import ui.Abstract_UI;
import ui.TUI;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Game and all its fields and methods
 * Represents the logic of the game throughout it. Is to act between the inputs from the ui layer and the domain layer
 * according to this logic
 */
public class Game {
    private Player currPlayer;      //Instances of Player
    private Player[] players;
    private Board board;
    private Cup cup;
    private Abstract_UI ui;
    private boolean isOn;

    /**
     * Constructor of Game class
     */
    public Game() {
        ui = new TUI();

        int numberOfPlayers = ui.askForNumberOfPlayers();
        players = new Player[numberOfPlayers];

//        this.board = new Board(24, players);
        this.board = new Board(24, this);
        this.cup = new Cup();

        ArrayList<String> names = ui.askForNames(players.length);

        for(int i=0; i<players.length; i++){
            players[i] = new Player(names.get(i),board, cup);
        }

        currPlayer = players[0];

        isOn = true;
    }

    public void run(){
        ui.setGame(this);

        while(isOn){
            for (Player player: players) { //TODO KNA: Either fix this to standard for-loop or be ready to defend it since it doesn't hold up to "inititiate-condition-afterthought"/"index-condition-increment"
                currPlayer = player;

                if(ui.askToTakeTurn()){
                    player.takeTurn();
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
        return board.getSquare(currPlayer.getCurrPosition());
    }

    //TODO skal implementeres, hvis der to vinder
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
    public Game(int numberOfPlayers) {
        ui = new TUI();
        players = new Player[numberOfPlayers];
//        this.board = new Board(24, players);
        this.board = new Board(24, this);
        this.cup = new Cup();

        for(int i=0; i<players.length; i++){
            players[i] = new Player("",board, cup);
        }
        currPlayer = players[0];
        isOn = true;
    }

    /**
     * Test method, might be able to be fixed by new constructor
     * @return
     */
    public Player[] getPlayers(){
        return players;
    }

    public Board getBoard() {
        return board;
    }
}