package model.squareTypes;

import model.Player;

public class StartSquare extends Square {

    public StartSquare(String scenario){
        super(scenario);
    }

    //FixMe KNA: This only happens when you pass.. is there even control for that at the moment?
    @Override
    public void landedOn(Player p) {
    }

}
