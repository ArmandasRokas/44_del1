package model.squareTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the abstract Square class and all of its fields and methods
 * Class to represent the squares on board. Is not to be created instances of, since all squares are to be unique classes.
 */
public abstract class Square {
    protected String scenario;  //Name of square, used to describe the scenario of the turn

    /**
     *  Super-constructor of Square's subclasses
     *
     * @param scenario  Name of the square
     */
    public Square(String scenario){
        this.scenario = scenario;
}

    /**
     * Get method of scenario
     *
     * @return  Name of square
     */
    public String getScenario(){
        return this.scenario;
    }

    /**
     * Abstract method, to act on the squares scenario
     *
     * @param p Instance of player who have landed on the square
     */
    public abstract void landedOn(Player p);

    /**
     * toString method of Square
     *
     * @return  Message of Square
     */
    public String toString(){
        return scenario;
    }
}
