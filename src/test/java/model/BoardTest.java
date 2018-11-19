package model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing
 *
 */

class BoardTest {

    @Test
    void getNewPositionTest(){

        //Arrange

        Board board = new Board(12);

        int boardLength = board.getLength();
        int startPosition = 0;
        int expAfterMovingToLastSquare = boardLength - 1;
        int expAfterMovingOneRound = 0;


        //Act


        int newPositionAfterMovingToLastSquare = board.getNewPosition(startPosition, boardLength-1);
        int newPositionAfterMovingOneRound = board.getNewPosition(boardLength - 1, 1);


        //Assert

        assertEquals(expAfterMovingToLastSquare, newPositionAfterMovingToLastSquare );
        assertEquals(expAfterMovingOneRound, newPositionAfterMovingOneRound );


    }

}