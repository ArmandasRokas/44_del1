package model.AllSquares;

import model.Player;

public abstract class Square {

    protected String scenario;
    protected String name;

    public Square(String name, String scenario){
        this.name = name;
        this.scenario = scenario;
}

    public String getScenario(){
        return this.scenario;
    }

    public abstract void landedOn(Player p);
}
