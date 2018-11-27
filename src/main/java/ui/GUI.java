package ui;

import com.sun.java.util.jar.pack.Instruction;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class GUIBoundary extends Abstract_UI {
    private GUI gui;
    private GUI_Field[] fields;
    private GUI_Player[] players;

    Scanner scan = new Scanner(System.in);

    @Override
    public void sayWelcome() {
        System.out.println("Welcome to Monopoly Junior edition");
    }

    @Override
    public int askForNumberOfPlayers() {
        System.out.println("Enter amount of players");
        String input = scan.nextLine();
        switch (input.toLowerCase()){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                System.out.println("Wrong input");
                return -1;
        }
    }

    @Override
    public ArrayList<String> askForNames(int numberOfPlayers) {
        ArrayList<String> names = new ArrayList<>();
        for( int i=0; i < numberOfPlayers; i++)\{
            System.out.println("Enter player name");
            String input = scan.nextLine();
            names.add(input);
        }
        return null;
    }

    @Override
    public boolean askToTakeTurn() {

    }

    @Override
    public boolean updateBoardView() {

    }
}
