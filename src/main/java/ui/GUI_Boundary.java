package ui;


import controller.GameController;
import gui_main.GUI;

import java.util.ArrayList;

public class GUI_Boundary extends Abstract_UI {

    GUI gui = new GUI();

    @Override
    public void sayWelcome() {


    }

    @Override
    public int askForNumberOfPlayers() {

        int numberOfPlayers = gui.getUserInteger("Indtast antallet af spillere");

        return numberOfPlayers;
    }

    @Override
    public ArrayList<String> askForNames(int numberOfPlayers) {
        return null;
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
