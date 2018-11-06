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


    /**Starts the dice game
     *
     */
    public void startDicegame(){

        boolean activeGame = true;
        System.out.println(content.get(1));
        Scanner scan = new Scanner(System.in);

        while (activeGame){
            System.out.println(content.get(2) + game.getCurrentplayer().getNumber() + content.get(3)); //TODO skal laves om at den kalder kun game classe.
            System.out.println("Tast 1 for at slå med terningerne eller skriv 'Stop' for at afslutte spillet.");
            String input = scan.nextLine();

            switch (input.toLowerCase()){
                case "1":
                    game.playRound();
                    System.out.println(game.getCurrentplayer().getNumber() + " har slået: " + game.getCurrentRollScore());
                    printCurrScores();

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
            if (game.getCurrentplayer().getTotalScore() >= 40){ //TODO skal laves en metod isCurPlayerWinner
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
        System.out.println("Spiller 1 har: " + game.getP1().getTotalScore() + " points.");
        System.out.println("Spiller 2 har: " + game.getP2().getTotalScore() + " points.");
    }

    public void loadContent(){

        try {
            content = GameTool.readFromFile("DK_UI");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
