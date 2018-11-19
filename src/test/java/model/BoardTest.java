package model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test case: TC5
 *
 * Tests if a new position calculated by the getNewPosition method
 * in the Board class is not extending the number of squares.
 * In other words, the method starts counting position from
 * the beginning, if the end of squares reaches.
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