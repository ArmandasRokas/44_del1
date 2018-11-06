package model;

import util.GameTool;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    private Square squareList[];
    private Square currSquare;
    private ArrayList<String> content;



    public Board(int squareAmount) {
        squareList = new Square[squareAmount];

        this.setBoard();
        loadContent();

    }

    public void loadContent(){


        try {
            content = GameTool.readFromFile("DK_scenarios");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    private void setBoard() {
        squareList[0] = new Square(content.get(1),250);
        squareList[1] = new Square(content.get(2),-100);
        squareList[2] = new Square(content.get(3),100);
        squareList[3] = new Square(content.get(4),-20);
        squareList[4] = new Square(content.get(5),180);
        squareList[5] = new Square(content.get(6),0);
        squareList[6] = new Square(content.get(7),-70);
        squareList[7] = new Square(content.get(8),60);
        squareList[8] = new Square(content.get(9),-80);
        squareList[9] = new Square(content.get(10),-50);
        squareList[10] = new Square(content.get(11),650);

    }

    public String getCurrScenerio(){

        return currSquare.getScenario();


    }

    public int getCurrMoneyInfluence(){
        return currSquare.getCashInfluence();

    }


    public void updateCurrSquare(int totalEye){

        switch (totalEye){
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
}

