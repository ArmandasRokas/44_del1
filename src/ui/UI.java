package ui;

import controller.Game;
import util.GameTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**@author Hold 44
 * @version 11/10-2018
 *
 * Defines the UI class
 */
public class UI {

    private Game game;
    private ArrayList<String> content;

    /**
     * Constructor of UI and initializes Game
     */
    public UI() {
        game = new Game();
        loadContent();
    }

    public static void main(String[] args) {

        UI ui = new UI();
        ui.startDicegame();

    }


    /**Starts the dice game
     *
     */
    public void startDicegame(){

        boolean activeGame = true;
        System.out.println(content.get(1));
        Scanner scan = new Scanner(System.in);

        while (activeGame){
            System.out.println(content.get(2) + game.getCurrPlayerNumber() + content.get(3)); //TODO skal laves om at den kalder kun game classe.
            System.out.println(content.get(4));
            String input = scan.nextLine();

            switch (input.toLowerCase()){
                case "1":
                    game.playRound();
                    System.out.println(game.getCurrPlayerNumber() + content.get(5)  + game.getCurrentRollScore());
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

    public void printCurrScores() {
        System.out.println(content.get(14) + game.getPlayerTotalCash(1) + " points.");
        System.out.println(content.get(15) + game.getPlayerTotalCash(2) + " points.");
    }

    //TODO should be created new class "UI_Content" in domain model, because now it has directly association with technical service layer

    public void loadContent(){

        try {
            content = GameTool.readFromFile("DK_UI");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
