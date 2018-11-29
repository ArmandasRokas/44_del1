package model.chanceCardTypes;

import model.Board;
import model.Player;

public abstract class ChanceCard {
    private String scenario;

    public ChanceCard(String scenario) {
        this.scenario = scenario;
    }

    public abstract void actOnCard(Player p);

    public String getScenario(){
        return scenario;
    }
}
