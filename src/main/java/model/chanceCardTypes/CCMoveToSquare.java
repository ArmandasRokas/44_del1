package model.chanceCardTypes;

import model.Board;
import model.Player;

public class CCMoveToSquare extends ChanceCard {
    private String squareName; //fixme Kun relevant med toString?
    private int squareNmb;

    public CCMoveToSquare(String scenario, String squareName, Board board) {
        super(scenario);
        this.squareName = squareName;
        this.squareNmb = findSquare(squareName, board);
    }

    @Override
    public void actOnCard(Player p) {
        p.moveToSquare(squareNmb);
    }

    private int findSquare(String squareName, Board board) {
        int index = board.findSquareByName(squareName);
        return index;
    }
}
