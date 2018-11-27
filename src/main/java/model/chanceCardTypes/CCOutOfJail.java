package model.chanceCardTypes;

import model.Player;
//TODO opret metode til onHand, så flere spillere ikke kan trække det samme kort samtidigt.
public class CCOutOfJail extends ChanceCard {
//    private boolean onHand;

    public CCOutOfJail(String scenario) {
        super(scenario);
//        this.onHand = false;
    }

    public void actOnCard(Player p) {
//        this.onHand = true;
        p.giveOutOfJailCard();
    }
}