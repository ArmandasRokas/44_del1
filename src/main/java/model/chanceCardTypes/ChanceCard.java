package model.chanceCardTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the abstract ChanceCard class and all of its fields and methods
 * Class to represent the chance cards of the game. Is not to be created instances of, since all cards are to be unique classes.
 */
public abstract class ChanceCard {
    private String scenario;    //Scenario of the chance card

    /**
     * Super-constructor for ChanceCard's subclasses
     *
     * @param scenario  Scenario of the chance card
     */
    public ChanceCard(String scenario) {
        this.scenario = scenario;
    }

    /**
     * Acts out the scenario of the card
     *
     * @param p Player to be affected by the card
     */
    public abstract void actOnCard(Player p);

    /**
     * toString method of ChanceCard
     *
     * @return  Scenario of the card
     */
    public String getScenario(){
        return scenario;
    }
}
