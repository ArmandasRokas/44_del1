package model.chanceCardTypes;

import model.Board;
import model.Player;

public class CCMoveToSquare extends ChanceCard {
    private String squareName; //fixme Kun relevant med toString?
    private int squareNmb;
    private Board board;

    public CCMoveToSquare(String scenario, String squareName, Board board) {
        super(scenario);
        this.squareName = squareName;
        this.board = board;
//        this.squareNmb = findSquare(squareName, board);
    }

    @Override
    public void actOnCard(Player p) {
        p.moveToSquare(findSquare(squareName, board));
    }

    private int findSquare(String squareName, Board board) {
        int index = board.findSquareByName(squareName);
        return index;
    }
}
