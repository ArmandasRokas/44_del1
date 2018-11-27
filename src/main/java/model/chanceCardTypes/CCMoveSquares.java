package model.chanceCardTypes;

import model.Player;

public class CCMoveSquares extends ChanceCard {
    private int squaresToMove;

    public CCMoveSquares(String scenario, int squaresToMove) {
        super(scenario);
        this.squaresToMove = squaresToMove;
    }

    @Override
    public void actOnCard(Player p) {
        p.movePlayer(this.squaresToMove); //TODO Skal fikses så det passer når Armandas har flyttet metode.
    }
}
