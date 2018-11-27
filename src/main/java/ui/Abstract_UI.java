package ui;

import controller.Game;

import java.util.ArrayList;

public abstract class Abstract_UI {

    protected Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public abstract void sayWelcome();

    public abstract int askForNumberOfPlayers();

    public abstract ArrayList<String> askForNames(int numberOfPlayers);

    public abstract boolean askToTakeTurn();

  //  public abstract boolean showDiesResult();

    public abstract boolean updateBoardView();

    public abstract boolean showFinalResult();

}
