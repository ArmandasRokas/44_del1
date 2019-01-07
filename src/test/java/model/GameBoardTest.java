package model;

import controller.GameController;
import model.squareTypes.PropertySquare;
import model.squareTypes.Square;
import org.junit.jupiter.api.Test;
import ui.Abstract_UI;
import ui.GUI_Boundary;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void setPropertySquareSiblingsTest(){

        //Arrange


        class GB extends Abstract_UI{

            @Override
            public void sayWelcome() {

            }

            @Override
            public int askForNumberOfPlayers() {
                return 0;
            }

            @Override
            public String[] askForNames(int numberOfPlayers) {
                return new String[0];
            }

            @Override
            public int askToChooseAction() {
                return 0;
            }

            @Override
            public boolean showPlayerAction() {
                return false;
            }

            @Override
            public boolean updateBoardView() {
                return false;
            }

            @Override
            public boolean showFinalResult() {
                return false;
            }

            @Override
            public boolean showCurrentDiesResult() {
                return false;
            }

            @Override
            public boolean setPlayers(String[] names, int numberOfPlayers) {
                return false;
            }

            @Override
            public boolean askToBuyProperty() {
                return false;
            }

            @Override
            public boolean setOwnerOnSquare(String name, int index) {
                return false;
            }

            @Override
            public String askToChoosePropertyToBuildHouse(String[] properties) {
                return null;
            }

            @Override
            public boolean buildHouse(int index) {
                return false;
            }
        }

        //Act

        GameBoard gameBoard = new GameBoard(new GameController() ,new GB(), true);


        //Assert
        Square[] squares = gameBoard.getSquareList();

        for(Square s: squares){

            boolean isSizeMoreThanZero = false;

            if(s instanceof PropertySquare){
                PropertySquare ps = (PropertySquare) s;
                if (ps.getSiblingSquares().size() > 0) {
                    isSizeMoreThanZero = true;
                }
                assertTrue(isSizeMoreThanZero);
            }
        }

        //TODO checks size
        //TODO checks first middle and last squares is set correctly
    }

}