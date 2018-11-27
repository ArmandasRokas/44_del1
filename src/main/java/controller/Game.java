package controller;

import model.Board;
import model.Cup;
import model.Die;
import model.Player;
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
    private int winCondition;
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

        this.board = new Board(24, players);
        this.cup = new Cup();

        ArrayList<String> names = ui.askForNames(players.length);

        for(int i=0; i<players.length; i++){
            players[i] = new Player(names.get(i),board, cup);
        }

        currPlayer = players[0];
    }

    public void run(){
        ui.setGame(this);

        while(isOn){
            for (Player player: players) {
                currPlayer = player;

                ui.askToTakeTurn();
                player.takeTurn();
                ui.updateBoardView();
            }
        }
    }


    /**
     * This constructor is just for testing purposes!
     */
//    public Game(Player p1){
//        this.p1 = p1;
//        this.currPlayer = p1;
//        this.winCondition = 3000;
//        this.board = new Board(24,true);
//
//    }

    /**
     * Plays the essentials of a players turn. Rolls the dices, checks on what effect it has
     * on the player and acts on it
     */
    public void playRound() {  // Måske ændre navn til newRound() ?


    //    int totalEye = getCurrentRollScore();
    //    board.updateCurrSquare(totalEye);

        int currCashInfluence = this.getCurrCashInfluence();
        this.currPlayer.addToCash(currCashInfluence);
    }

    /**
     * Method to control if a winner has been found
     *
     * @return  boolean which is true if a winner has been found
     */
    //TODO skal overvejes til at flytte metodens logik til Player class og laves om til taber fundet
    public boolean winnerFound() {
        boolean res = false;
        if(currPlayer.getTotalCash() >= winCondition) {
            res = true;
        }
        return res;
    }

    /**
     * Sets up round for next player if to be changed, else it does nothing
     */
    public void endRound() {
        if(!board.checkExtraTurn()) {
            this.changePlayer();
        }
    }

    /**
     * Changes current player
     */
    private void changePlayer() {
        if(currPlayer.equals(p1)) {
            this.currPlayer = p2;
        } else if(currPlayer.equals(p2)) {
            this.currPlayer = p1;
        }
    }



    /**
     * Get methods to get instance of current player
     *
     * @return  Instance of Player
     */
    public String getCurrPlayerNumber(){
        return currPlayer.getNumberOfPlayers();
    }

    /**
     * Gets the total amount of cash currently stashed by a given player
     *
     * @param playerNumber  The number of which player is to be checked
     * @return              Amount of cash stashed
     */
    public int getPlayerTotalCash(int playerNumber){
        if (playerNumber == 1){
            return p1.getTotalCash();
        } else{
            return p2.getTotalCash();
        }
    }

    /**
     * Gets what scenario the current square is
     *
     * @return  String of what the scenario says
     */
    public String getCurrScenario() {
        return board.getCurrScenerio();
    }

    /**
     * Gets what effect of the current square has on the players account
     *
     * @return  An integer of what effect it will have on the players account
     */
    public int getCurrCashInfluence() {
        return board.getCurrCashInfluence();
    }

    /**
     * Controls if the Square is meant to give the player an extra turn
     *
     * @return  Boolean which is true if the player is to get an extra turn, else it is false
     */
    public boolean checkExtraTurn(){
        return board.checkExtraTurn();
    }




}