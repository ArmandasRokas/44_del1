package ui;

import controller.Game;
import ui.UI;
import util.GameTool;

public class Main {

    public static void main(String[] args) {
      //  testRoll();

       // UI ui = new UI();
       // ui.startDicegame();

        Game game = new Game();

        game.playRound();

        System.out.println(game.getCurrScenario() + " " + game.getCurrMoneyInfluence());


    }

    public static void testRoll(){

        for (int i=0; i<1000; i++){

            int random = GameTool.randomIntValue(10,20);

            if (random > 20 || random < 10){
                System.out.println("Du fejlet!");
            }

            System.out.println(random);

        }

    }
}
