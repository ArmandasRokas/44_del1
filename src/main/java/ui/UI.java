package ui;

import controller.Game;
import util.GameTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the UI class and its fields and methods
 * Takes inputs from user and directs it through the system
 */
public class UI {
    private Game game;
    private ArrayList<String> content;


    /**
     * Constructor of UI and initializes a game and loads the ui and scenarios for it
     */
    private UI() {
        game = new Game();
        loadContent();
    }

    /**
     *  Starts the dice game
     */
    private void startDicegame(){
        boolean activeGame = true;
        System.out.println(content.get(1));
        Scanner scan = new Scanner(System.in);

        while (activeGame){
            System.out.println(content.get(2) + game.getCurrPlayerNumber() + content.get(3));
            System.out.println(content.get(4));
            String input = scan.nextLine();

            switch (input.toLowerCase()){
                case "1":
                    game.playRound();
     //               System.out.println(game.getCurrPlayerNumber() + content.get(5)  + game.getCurrentRollScore());
                    System.out.println(content.get(6) + " " + game.getCurrScenario() + content.get(7) + " " + game.getCurrCashInfluence());

                    if(game.checkExtraTurn()) {
                        System.out.println(content.get(8));
                        System.out.println();
                    } else {
                        System.out.println();
                        printCurrScores();
                        System.out.println();
                    }
                    if (game.winnerFound()){
                        activeGame = false;
                        System.out.println(content.get(9) + " " + game.getCurrPlayerNumber() + content.get(10));
                    }
                    game.endRound();
                    break;

                case "stop":
                    activeGame = false;
                    break;

                default:
                    System.out.println(content.get(11));
                    break;
            }
        }
        System.out.println();
        System.out.println(content.get(12));
        printCurrScores();
        System.out.println(content.get(13));
    }

    /**
     * Prints the current scores of the players
     */
    private void printCurrScores() {
        System.out.println(content.get(14) + game.getPlayerTotalCash(1) + "$");
        System.out.println(content.get(15) + game.getPlayerTotalCash(2) + "$");
    }

    //#TODO Consideration for next time: Create new class "UI_Content" in domain model, because now it has directly association with technical service
    /**
     * Loads the UI outputs from hardcoded filename
     */
    private void loadContent(){
        try {
            content = GameTool.readFromFile("DK_UI");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}