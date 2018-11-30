package ui;

import model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI extends Abstract_UI {

    Scanner scan = new Scanner(System.in);

    @Override
    public void sayWelcome() {

    }

    @Override
    public int askForNumberOfPlayers() {
        System.out.println("Choose 2-4 number of players: ");
        String input = scan.nextLine();
        switch (input.toLowerCase()){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                System.out.println("Invalid input");
                return -1;
        }
    }

    public ArrayList<String> askForNames(int numberOfPlayers){
        ArrayList<String> names = new ArrayList<>();

        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Write player name: ");
            String input = scan.nextLine();
            names.add(input);
        }
        return names;
    }

    @Override
    public boolean askToTakeTurn() {
        System.out.println(gameController.getCurrPlayerName() + " has a turn.");
        System.out.println("Press 1 for roll dice: ");
        String input = scan.nextLine();
        if(input.equals("1")){
            return true;
        } else {
            System.out.println("Invalid input");
            askToTakeTurn();
            return false;
        }
    }

    @Override
    public boolean showScenario() {
        System.out.println(gameController.getCurrSquare().toString());
        return false;
    }

    @Override
    public boolean updateBoardView() {
        for (Player p: gameController.getPlayers()) {
            System.out.println(p.toString());
        }
        return true;
    }

    @Override
    public boolean showFinalResult() {
        System.out.println("The winner is: " + gameController.getWinnerName());
        updateBoardView();
        return true;
    }

    @Override
    public boolean showCurrentDiesResult() {

        System.out.println(gameController.getCurrPlayerName() + " rolled " + gameController.getCurrentDiesTotal());

        return false;
    }
}
