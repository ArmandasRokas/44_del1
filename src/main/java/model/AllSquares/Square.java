package model.AllSquares;

import model.Player;

public abstract class Square {

    protected String scenario;

    public Square(String scenario){
        this.scenario = scenario;
    }

    abstract public void landedOn(Player p);
}
