package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI extends Abstract_UI {

    Scanner scan = new Scanner(System.in);

    @Override
    public int askForNumberOfPlayers() {
        System.out.println("Write number of players: ");
        String input = scan.nextLine();
        switch (input.toLowerCase()){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                System.out.println("Forkert input");
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
}
