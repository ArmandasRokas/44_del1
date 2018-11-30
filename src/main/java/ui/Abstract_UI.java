package ui;

import controller.GameController;

import java.util.ArrayList;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the abstract class, Abstract_UI, and all of its fields and methods
 * Class to represent the "Get out of jail"-card of the game
 */
public abstract class Abstract_UI {
    protected GameController gameController;

    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    public abstract void sayWelcome();

    public abstract int askForNumberOfPlayers();

    public abstract ArrayList<String> askForNames(int numberOfPlayers);

    public abstract boolean askToTakeTurn();

    public abstract boolean showScenario();

    public abstract boolean updateBoardView();

    public abstract boolean showFinalResult();

    public abstract boolean showCurrentDiesResult();

}
