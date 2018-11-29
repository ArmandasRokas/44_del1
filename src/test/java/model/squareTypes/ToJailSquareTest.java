package model.squareTypes;

import controller.Game;
import model.Board;
import model.Cup;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToJailSquareTest {

    @Test
    void landedOn() {
        //Arrange
        Game game = new Game(2);
        Board board = new Board(24,game);
        Cup cup = new Cup();

        Player[] players = game.getPlayers();

        Player p = players[1];

        int expectedPos;
        int actualPos;

        //Index for Jail
        expectedPos = 6;

        //Act
        Player p1 = new Player("1",board,cup);
        Square toJailSquare = board.getSquare(18);
        toJailSquare.landedOn(p);

        actualPos = p.getCurrPosition();

        //Assert
        assertEquals(expectedPos,actualPos);
    }
}

