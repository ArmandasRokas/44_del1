package model.squareTypes;

import controller.Game;
import model.Board;
import model.Cup;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToJailSquareTest {

    /**Test case: TC2
     *
     * Tests if the player is moved to jail when he hits the "Go to Jail" square
     *
     */
    @Test
    void toJailLandedOnTest() {
        //Arrange
        Game game = new Game(2);
        Board board = new Board(24,game);
        Cup cup = new Cup();

        Player[] players = game.getPlayers();
        Player p = players[1];

        int expectedPos = board.findSquareByName("Prison"); //Index for Jail

        //Act
        Player p1 = new Player("1",board,cup);
        Square toJailSquare = board.getSquare(18);
        toJailSquare.landedOn(p);

        int actualPos = p.getCurrPosition();

        //Assert
        assertEquals(expectedPos,actualPos);
    }
}

