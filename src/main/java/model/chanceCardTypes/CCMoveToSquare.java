package model.chanceCardTypes;

import model.GameBoard;
import model.Player;

public class CCMoveToSquare extends ChanceCard {
    private String squareName; //fixme Kun relevant med toString?
//    private int squareNmb;
    private GameBoard gameBoard;

    public CCMoveToSquare(String scenario, String squareName, GameBoard gameBoard) {
        super(scenario);
        this.squareName = squareName;
        this.gameBoard = gameBoard;
//        this.squareNmb = findSquare(squareName, gameBoard);
    }

    @Override
    public void actOnCard(Player p) {
        p.moveToSquare(findSquare(squareName, gameBoard));
    }

    private int findSquare(String squareName, GameBoard gameBoard) {
        int index = gameBoard.findSquareByName(squareName);
        return index;
    }
}
