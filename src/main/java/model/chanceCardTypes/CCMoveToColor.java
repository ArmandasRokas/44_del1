package model.chanceCardTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the CCMoveToColor class and all of its fields and methods
 * Class to represent the "Get out of jail"-card of the game
 */
//TODO Implement card and create instances of it in init of ChanceSquare
public class CCMoveToColor extends ChanceCard {
    private String color;   //Color group of the square player can choose from to move to

    /**
     * Constructor of CCMoveToColor
     *
     * @param scenario  Scenario of the card
     * @param color     Color group of the square player can choose from to move to
     */
    public CCMoveToColor(String scenario, String color) {
        super(scenario);
        this.color = color;
    }

    /**
     * Moves the player to a chosen square in the given color group and gives it to the player for free
     *
     * @param p Player to be affected by the card
     */
    @Override
    public void actOnCard(Player p) {
        //TODO Card first interesting when input from user i possible.
        //What it's supposed to do: Move a player to a specfic color square and give if free, else pays the current owner. Advanced use: Player can choose which square in the color group
    }
}
