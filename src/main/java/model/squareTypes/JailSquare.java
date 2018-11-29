package model.squareTypes;

import model.Player;

public class JailSquare extends Square {


    public JailSquare(String scenario){
        super(scenario);
    }

    //TODO skal implementeres
    //TODO KNA: What is to be implemented?
    @Override
    public void landedOn(Player p) {

    }

    @Override
    public String toString() {
        return "You are visiting " + super.toString();
    }
}
