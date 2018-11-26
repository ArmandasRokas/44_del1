package model.squareTypes;

import model.Player;

public class StartSquare extends Square {

    public StartSquare(String scenario){
        super(scenario);
    }


    @Override
    public void landedOn(Player p) {
        p.addToCash(2);
    }

}
