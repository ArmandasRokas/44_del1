package model;

import controller.GameController;
import org.junit.jupiter.api.Test;
import ui.GUI_Boundary;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void setPropertySquareSiblingsTest(){

        //Arrange

        GUI_Boundary gui_boundary = new GUI_Boundary();
        GameController gameController = new GameController();





        //Act
        GameBoard gameBoard = new GameBoard(gameController, gui_boundary);


        //Assert

        //TODO checks size
        //TODO checks first middle and last squares is set correctly
    }

}