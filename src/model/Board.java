package model;

import util.GameTool;

import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private Square squareList[];
    private Square currSquare;
    private ArrayList<String> scenerioStrings;



    public Board(int squareAmount) {
        squareList = new Square[squareAmount];
        loadContent();
        this.setBoard();
    }

    private void loadContent(){
        try {
            scenerioStrings = GameTool.readFromFile("EN_scenarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setBoard() {
        squareList[0] = new Square(scenerioStrings.get(1),250);
        squareList[1] = new Square(scenerioStrings.get(2),-100);
        squareList[2] = new Square(scenerioStrings.get(3),100);
        squareList[3] = new Square(scenerioStrings.get(4),-20);
        squareList[4] = new Square(scenerioStrings.get(5),180);
        squareList[5] = new Square(scenerioStrings.get(6),0);
        squareList[6] = new Square(scenerioStrings.get(7),-70);
        squareList[7] = new Square(scenerioStrings.get(8),60);
        squareList[8] = new Square(scenerioStrings.get(9),-80, true);
        squareList[9] = new Square(scenerioStrings.get(10),-50);
        squareList[10] = new Square(scenerioStrings.get(11),650);
    }

    public String getCurrScenerio(){
        return currSquare.getScenario();
    }

    public int getCurrCashInfluence(){
        return currSquare.getCashInfluence();
    }


    public void updateCurrSquare(int totalEyes){
        switch (totalEyes){
            case 2:
                currSquare = squareList[0];
                break;
            case 3:
                currSquare = squareList[1];
                break;
            case 4:
                currSquare = squareList[2];
                break;
            case 5:
                currSquare = squareList[3];
                break;
            case 6:
                currSquare = squareList[4];
                break;
            case 7:
                currSquare = squareList[5];
                break;
            case 8:
                currSquare = squareList[6];
                break;
            case 9:
                currSquare = squareList[7];
                break;
            case 10:
                currSquare = squareList[8];
                break;
            case 11:
                currSquare = squareList[9];
                break;
            case 12:
                currSquare = squareList[10];
                break;
            default:
                currSquare = null;
        }
    }

    public boolean checkExtraTurn() {
        return currSquare.checkExtraTurn();
    }
}

