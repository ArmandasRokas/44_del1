package model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test case: TC1
 *
 * Tests if a new position is not extending the number of squares.
 * In other words, the method starts counting position from
 * the beginning, if the end of squares reaches.
 *
 */

class GameControllerBoardTest {
    @Test
    void getNewPositionTest(){
        //Arrange
        int boardLength = 12;
        GameBoard gameBoard = new GameBoard(boardLength,true);
        int startPosition = 0;
        int expAfterMovingToLastSquare = boardLength - 1;

        //Act
        int newPosition_Last_Square = gameBoard.getNewPosition(startPosition, boardLength-1);
        int newPosition_Completing_One_Round = gameBoard.getNewPosition(startPosition, boardLength);

        //Assert
        assertEquals(expAfterMovingToLastSquare, newPosition_Last_Square );
        assertEquals(startPosition, newPosition_Completing_One_Round );
    }


}
