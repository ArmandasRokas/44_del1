package model.squareTypes;

import model.Player;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the abstract Square class and all of its fields and methods
 * Class to represent the squares on board. Is not to be created instances of, since all squares are to be unique classes.
 */
public abstract class Square {
    protected String scenario;

    /**
     *
     *
     * @param scenario
     */
    public Square(String scenario){
        this.scenario = scenario;
}

    public String getScenario(){
        return this.scenario;
    }

    public abstract void landedOn(Player p);

    public String toString(){
        return scenario;
    }
}
