package model;

public class Board {
    private Square squareList[];

    private Square currSquare;

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
        squareList[8] = new Square( "The Werewall (extra turn)",-80, true);
        squareList[9] = new Square( "The pit",-50);
        squareList[10] = new Square("Goldmine",650);
//        squareList[0] = new Square(2,"Tower",250);
//        squareList[1] = new Square(3, "Crater",-100);
//        squareList[2] = new Square(4, "Palace gates",100);
//        squareList[3] = new Square(5, "Cold Desert",-20);
//        squareList[4] = new Square(6, "Walled city",180);
//        squareList[5] = new Square(7, "Monastery",0);
//        squareList[6] = new Square(8, "Black cave",-70);
//        squareList[7] = new Square(9, "Huts in the mountain",60);
//        squareList[8] = new Square(10, "The Werewall (extra turn)",-80);
//        squareList[9] = new Square(11, "The pit",-50);
//        squareList[10] = new Square(12, "Goldmine",650);
    }

    public String getCurrScenerio(){

        return currSquare.getScenario();


    }

    public int getCurrCashInfluence(){
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

    public boolean checkExtraTurn() {
        return currSquare.checkExtraTurn();
    }
}

