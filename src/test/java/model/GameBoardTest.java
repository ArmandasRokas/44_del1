package model;

import controller.GameController;
import model.squareTypes.Square;
import org.junit.jupiter.api.Test;
import ui.GUI_Boundary;

class GameBoardTest {

    @Test
    void setPropertySquareSiblingsTest(){

        //Arrange

        GUI_Boundary gui_boundary = new GUI_Boundary();
        GameController gameController = new GameController();

        //Act
        GameBoard gameBoard = new GameBoard(gameController, gui_boundary);


        //Assert

        Square[] squares = gameBoard.getSquareList();

        for(Square s: squares){



        }

        //TODO checks size
        //TODO checks first middle and last squares is set correctly
    }

}