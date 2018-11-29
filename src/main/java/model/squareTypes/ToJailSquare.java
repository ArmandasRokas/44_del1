package model.squareTypes;

import model.Board;
import model.Player;

public class ToJailSquare extends Square {
    int squareNumber;
    Board board;

    public ToJailSquare(String scenario, Board board){
        super(scenario);
        this.board = board;

    }

    //TODO skal implementeres
    @Override
    public void landedOn(Player p) {
        this.squareNumber = findSquare(board);
        p.moveToSquare(squareNumber);
    }

    private int findSquare(Board board) {
        int index = board.findSquareByName("Prison");
        return index;
    }

    @Override
    public String toString() {
        return "You go to " + super.toString();
    }
}