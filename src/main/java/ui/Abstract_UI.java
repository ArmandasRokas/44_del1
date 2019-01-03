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

    /**
     * Sets reference to GameController for usage in UI's
     *
     * @param gameController    Reference to instance of GameController
     */
    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    /**
     * Greets the players
     */
    public abstract void sayWelcome();

    /**
     * Ask the players for number of players
     *
     * @return  Answer from players
     */
    public abstract int askForNumberOfPlayers();

    /**
     * Ask the players for their names, one by one
     *
     * @param numberOfPlayers   Number of players currently playing
     * @return                  List of player names
     */
    public abstract String[] askForNames(int numberOfPlayers);

    /**
     * Awaits players to take their turn
     *
     * @return  Boolean if input is accepted
     */
    public abstract boolean askToTakeTurn();

    /**
     * Writes out the scenario to players
     *
     * @return  [Usage to be implemented]
     */
    public abstract boolean showPlayerAction();

    /**
     * Prints or updates the text on scoreboard
     *
     * @return  [Usage to be implemented]
     */
    public abstract boolean updateBoardView();

    /**
     * Prints or updates the final scoreboard
     *
     * @return  [Usage to be implemented]
     */
    public abstract boolean showFinalResult();

    /**
     * Prints or updates the current roll
     *
     * @return [Usage to be implemented]
     */
    public abstract boolean showCurrentDiesResult();


    public abstract boolean setPlayers(String[] names, int numberOfPlayers);

    public abstract boolean askToBuyProperty();
}