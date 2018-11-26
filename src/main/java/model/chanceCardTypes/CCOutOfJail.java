package model.chanceCardTypes;

import model.ChanceCard;
import model.Player;

public class CCOutOfJail extends ChanceCard {
    private boolean onHand;

    public CCOutOfJail(String scenario) {
        super(scenario);
        this.onHand = false;
    }

    public void actOnCard(Player p) {
        this.onHand = true;
        p.giveOutOfJailCard();
    }
}