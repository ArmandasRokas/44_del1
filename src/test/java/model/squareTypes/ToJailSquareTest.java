package model.squareTypes;

import controller.GameController;
import model.GameBoard;
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
//    @Test
//    void toJailLandedOnTest() {
//        //Arrange
//        GameController gameController = new GameController(2);
//        GameBoard gameBoard = new GameBoard(24, gameController);
//        Cup cup = new Cup();
//
//        Player[] players = gameController.getPlayers();
//        Player p = players[1];
//
//        int expectedPos = gameBoard.findSquareByName("Prison"); //Index for Jail
//
//        //Act
//        Player p1 = new Player("1", gameBoard,cup);
//        Square toJailSquare = gameBoard.getSquare(18);
//        toJailSquare.landedOn(p);
//
//        int actualPos = p.getCurrPosition();
//
//        //Assert
//        assertEquals(expectedPos,actualPos);
//    }
}

