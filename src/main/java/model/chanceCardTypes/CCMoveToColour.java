package model.chanceCardTypes;

import model.ChanceCard;
import model.Player;

public class CCMoveToColour extends ChanceCard {
    private String colour;

    public CCMoveToColour(String scenario, String colour) {
        super(scenario);
        this.colour = colour;
    }

    @Override
    public void actOnCard(Player p) {
        //TODO Card first interesting when input from user i possible.
        //What it's supposed to do: Move a player to a specfic colour square and give if free, else pays the current owner.
    }
}
