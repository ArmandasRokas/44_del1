package ui;


import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import model.Player;

import java.util.ArrayList;

public class GUI_Boundary extends Abstract_UI {
    //TODO maybe delete Abstract_UI.
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
            gui_players[i] = new GUI_Player(names[i],30000);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }

        return true;
    }

    @Override
    public int askToChooseAction() {

        String action = gui.getUserButtonPressed(gameController.getCurrPlayerName() +
                " har turen."
                , "Kast", "Køb hus");
        switch (action){
            case "Kast":
                return 1;
            case "Køb hus":
                return 2;
            case "Køb hotel":
                return 3;
            case "Sælg hus":
                return 4;
        }
        return 0;
    }

    @Override
    public boolean showPlayerAction() {

        //TODO switch statment show player action, when player do something else than buy or rent property.
        gui.getUserButtonPressed(gameController.getCurrSquare().getPlayerAction(), "OK");

        return false;
    }

    @Override
    public boolean updateBoardView() {

        Player[] players = gameController.getPlayers();

        for(GUI_Field gui_field: fields){
            gui_field.removeAllCars();
        }

        for(int i = 0; i < players.length; i++){
            int playerBalance = players[i].getTotalCash();
            gui_players[i].setBalance(playerBalance);

            int currentPosition = players[i].getCurrPosition();
            fields[currentPosition].setCar(gui_players[i], true);

        }
        return true;


    }

    @Override
    public boolean showFinalResult() {



        return false;
    }

    @Override
    public boolean showCurrentDiesResult() {

        gui.setDice(gameController.getCurrentDiesValues()[0],gameController.getCurrentDiesValues()[1]);

        return true;
    }

    @Override
    public boolean askToBuyProperty(){

        boolean answer = gui.getUserLeftButtonPressed(
                gameController.getCurrPlayerName() + ", du har mulighed at købe " +
                gameController.getCurrSquare().toString() + ". Vil du det?",
                "ja", "nej");

        return answer;
    }

    @Override
    public boolean setOwnerOnSquare(String name, int index){

        fields[index].setSubText(name);

        return true;
    }

    @Override
    public String askToChoosePropertyToBuildHouse(String[] properties) {

        String answer = null;

        if(properties != null){
            answer = gui.getUserButtonPressed("Vælg en grund til at bygge hus", properties);
        }
        else {
            gui.getUserButtonPressed("Du har ingen grund til at bygge hus", "OK");
        }

        return answer;
    }

    @Override
    public boolean buildHouse(int index) {

        GUI_Street street = (GUI_Street)gui.getFields()[index];
        street.setHouses(1);

        return true;
    }
}
