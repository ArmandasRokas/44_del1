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
    private ArrayList<String> menuValues;

    /**
     * Constructor of UI and initializes Game
     */
    public UI() {
        game = new Game();
    }


    /**Starts the dice game
     *
     */
    public void startDicegame(){

        loadMenuValues();

        boolean activeGame = true;
        System.out.println(menuValues.get(0));
        Scanner scan = new Scanner(System.in);

        while (activeGame){
            System.out.println(menuValues.get(1) + game.getCurrentplayer().getNumber() + menuValues.get(2)); //TODO skal laves om at den kalder kun game classe.
            System.out.println("Tast 1 for at slå med terningerne eller skriv 'Stop' for at afslutte spillet.");
            String input = scan.nextLine();

            switch (input.toLowerCase()){
                case "1":
                    game.playRound();
                    System.out.println(game.getCurrentplayer().getNumber() + " har slået: " + game.getCurrentRollScore());
                    printCurrScores();

                    //TODO Hvorfor er dette altid false?
                    if(false) {
                        System.out.println("Tillykke, du har slået to ens! Du får en ekstra tur!");
                    }
                    break;

                case "stop":
                    activeGame = false;
                    break;

                default:
                    System.out.println("Forkert input, prøv igen.");
                    break;
            }
            if (game.getCurrentplayer().getTotalCash() >= 40){ //TODO skal laves en metod isCurPlayerWinner
                activeGame = false;
                System.out.println("Tillykke, " + game.getCurrentplayer().getNumber() + "! Du er vinderen");
            }
     //       game.switchPlayer();
        }
        System.out.println();
        System.out.println("Spillets resultat blev:");
        printCurrScores();
        System.out.println("Tak for spillet");
    }

    public void printCurrScores() {
        System.out.println("Spiller 1 har: " + game.getP1().getTotalCash() + " points.");
        System.out.println("Spiller 2 har: " + game.getP2().getTotalCash() + " points.");
    }

    public void loadMenuValues(){

        try {
            menuValues = GameTool.readFromFile("DK_UI");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
