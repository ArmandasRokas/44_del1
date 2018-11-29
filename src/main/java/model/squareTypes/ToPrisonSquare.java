package model.squareTypes;

import model.Board;
import model.Player;

public class ToPrisonSquare extends Square {
    int squareNumber;

    public ToPrisonSquare(String scenario, Board board){
        super(scenario);
        this.squareNumber = findSquare(board);
    }

    //TODO skal implementeres
    @Override
    public void landedOn(Player p) {
        p.moveToSquare(squareNumber);
    }

    private int findSquare(Board board) {
        int index = board.findSquareByName("Prison");
        return index;
    }
}