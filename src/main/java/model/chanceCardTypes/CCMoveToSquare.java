package model.chanceCardTypes;

import model.Player;

public class CCMoveToSquare extends ChanceCard {
    private String squareName; //fixme Kun relevant med toString?
    private int squareNmb;

    public CCMoveToSquare(String scenario, String squareName) {
        super(scenario);
        this.squareName = squareName;
        this.squareNmb = findSquare(squareName);
    }

    @Override
    public void actOnCard(Player p) {
        p.moveToSquare(squareNmb);
    }
}
