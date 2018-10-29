package model;

public class Board {
    private Square squareList[];

    public Board(int squareAmount) {
        squareList = new Square[squareAmount];

        this.setBoard();


    }


    private void setBoard() {
        squareList[0] = new Square("Tower",250);
        squareList[1] = new Square("Crater",-100);
        squareList[2] = new Square("Palace gates",100);
        squareList[3] = new Square("Cold Desert",-20);
        squareList[4] = new Square("Walled city",180);
        squareList[5] = new Square("Monastery",0);
        squareList[6] = new Square("Black cave",-70);
        squareList[7] = new Square("Huts in the mountain",60);
        squareList[8] = new Square("The Werewall (extra turn)",-80);
        squareList[9] = new Square("The pit",-50);
        squareList[10] = new Square("Goldmine",650);

    }


}

