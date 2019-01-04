package controller;

public class GameLogic {


    public boolean controlPlayerCount(int numberOfPlayers) {
        boolean res = false;
        if(numberOfPlayers >= 3 && numberOfPlayers <= 6) {
            res = true;
        }
        return res;
    }
}
