package model.squareTypes;

import model.GameBoard;
import model.Player;

public class ToJailSquare extends Square {
    int squareNumber;
    GameBoard gameBoard;

    public ToJailSquare(String scenario, GameBoard gameBoard){
        super(scenario);
        this.gameBoard = gameBoard;

    }

    //TODO skal implementeres
    @Override
    public void landedOn(Player p) {
        this.squareNumber = findSquare(gameBoard);
        p.moveToSquare(squareNumber);
    }

    private int findSquare(GameBoard gameBoard) {
        int index = gameBoard.findSquareByName("Prison");
        return index;
    }

    @Override
    public String toString() {
        return "You go to " + super.toString();
    }
}