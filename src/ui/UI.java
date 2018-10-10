package ui;

import controller.Game;

import java.util.Scanner;

public class UI {

    Game game = new Game();


    public void play(){

        int input;

        boolean isOn = true;
        System.out.println("Velkommen til vores terningespil");
        Scanner scan = new Scanner(System.in);
        while (isOn){
            System.out.println("Nu er det " + game.getCurrentplayer().getName() +"'s tur");
            System.out.println("Tast 1 for at slå med terningerne");
            input = scan.nextInt();
            switch (input){
                case 1:

                    game.roll();
                    System.out.println("Du har slået: " + game.getCurrentRollScore());

                    if (!game.isDiesHasValue()){
                        game.switchPlayer();
                    } else {
                        System.out.println("Tillykke, du har slået to ens! Du får en ekstra tur!");
                    }
            }

            if (game.getCurrentplayer().getTotalScore() >= 40){
                isOn = false;
                System.out.println("Til lykke, " + game.getCurrentplayer().getName() + "! Du er vinderen");
            }

        }

        System.out.println("Tak for spillet");
    }




}
