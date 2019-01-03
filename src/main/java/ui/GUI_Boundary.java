package ui;


import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import model.Player;

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
            gui_players[i] = new GUI_Player(names[i],30000);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }

        return true;
    }

    @Override
    public boolean askToTakeTurn() {

        gui.getUserButtonPressed(gameController.getCurrPlayerName() +
                " har turen."
                , "Kast");

        return true;
    }

    @Override
    public boolean showPlayerAction() {

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
}
