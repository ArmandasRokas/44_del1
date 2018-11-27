package model.chanceCardTypes;

import model.Board;
import model.Player;

public abstract class ChanceCard {
    private String scenario;
//    private boolean onHand; //Flyttet til CCOutOfJail

    public ChanceCard(String scenario) {
        this.scenario = scenario;
//        this.onHand = false;

    }

    public abstract void actOnCard(Player p);


}
