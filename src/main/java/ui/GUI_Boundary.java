package ui;


import controller.GameController;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;

public class GUI_Boundary extends Abstract_UI {

    GUI gui = new GUI();
    GUI_Field[] fields = gui.getFields();
    GUI_Player[] gui_players;

    @Override
    public void sayWelcome() {


    }

    @Override
    public int askForNumberOfPlayers() {

        int numberOfPlayers = gui.getUserInteger("Indtast antallet af spillere", 3,6);
        gui_players = new GUI_Player[numberOfPlayers];

        return numberOfPlayers;
    }

    @Override
    public String[] askForNames(int numberOfPlayers) {

        String[] names = new String[numberOfPlayers];

        for(int i = 0; i < numberOfPlayers; i++){

            String input = gui.getUserString("Indtast spiller " + (i+1) + " navn:");
            names[i] = input;
        }


        return names;
    }

    @Override
    public boolean setPlayers(String[] names, int numberOfPlayers) {

        for(int i = 0; i < numberOfPlayers; i++){
            gui_players[i] = new GUI_Player(names[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }

        return true;
    }

    @Override
    public boolean askToTakeTurn() {
        return false;
    }

    @Override
    public boolean showScenario() {
        return false;
    }

    @Override
    public boolean updateBoardView() {
        return false;
    }

    @Override
    public boolean showFinalResult() {
        return false;
    }

    @Override
    public boolean showCurrentDiesResult() {
        return false;
    }
}
