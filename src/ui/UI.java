package ui;

import controller.Game;

import java.util.Scanner;

public class UI {

    Game game = new Game();


    public void play(){

//        int input;

        boolean activeGame = true;
        System.out.println("Velkommen til vores terningespil!");
        Scanner scan = new Scanner(System.in);
        while (activeGame){
            System.out.println("Nu er det " + game.getCurrentplayer().getName() +"'s tur.");
            System.out.println("Tast 1 for at slå med terningerne eller skriv 'Stop' for at afslutte spillet.");
            String input = scan.nextLine();
            switch (input.toLowerCase()){
                case "1":
                    game.roll();
                    System.out.println("Du har slået: " + game.getCurrentRollScore());
                    printCurrScores();
                    if (!game.isDiesHasSameValue()){
                        game.switchPlayer();
                    } else {
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
            if (game.getCurrentplayer().getTotalScore() >= 40){
                activeGame = false;
                System.out.println("Tillykke, " + game.getCurrentplayer().getName() + "! Du er vinderen");
            }
        }
        System.out.println("Tak for spillet");
        System.out.println("Spillets resultat blev:");
        printCurrScores();
    }

    public void printCurrScores() {
        System.out.println("Spiller 1 har: " + game.getP1().getTotalScore() + " points.");
        System.out.println("Spiller 2 har: " + game.getP2().getTotalScore() + " points.");
    }
}
