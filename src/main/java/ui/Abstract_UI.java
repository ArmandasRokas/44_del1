package ui;

import controller.Game;

import java.util.ArrayList;

public abstract class Abstract_UI {

    private Game game;

    public abstract int askForNumberOfPlayers();

    public abstract ArrayList<String> askForNames(int numberOfPlayers);

    public void setGame(Game game){
        this.game = game;
    }
}
