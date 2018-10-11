package controller;

import model.Die;
import model.Player;

import java.util.Random;

public class Game {
    private Player p1, p2;
    private Die d1, d2;
    private Player currPlayer;

    //Constructor
    public Game() {
        this.p1 = new Player("Player 1");
        this.p2 = new Player("Player 2");

        this.d1 = new Die();
        this.d2 = new Die();

        this.currPlayer = p1;
    }

    public void play() {
        roll();
        if (!isDiesHasSameValue()) {
            switchPlayer();
        }
    }

    public void roll() {
        d1.setEyes(randomValue());
        d2.setEyes(randomValue());

        this.currPlayer.addToScore(getCurrentRollScore());
    }

    public int randomValue() {
        Random r = new Random();

        int randomNum = r.nextInt(6); // 0-5
        int finalNum = randomNum + 1;        // 1-6

        return finalNum;
    }

    public int getCurrentRollScore() {
        return d1.getEyes() + d2.getEyes();
    }

    public boolean isDiesHasSameValue() {
        if (d1.getEyes() == d2.getEyes()) {
            return true;
        } else {
            return false;
        }
    }

    public void switchPlayer() {
        if (currPlayer.equals(p1)) {
            currPlayer = p2;
        } else if (currPlayer.equals(p2)) {
            currPlayer = p1;
        }
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getCurrentplayer() {
        return currPlayer;
    }
}


//public class Time {
//    public static void main(String[] args)
//    {
//        // starting time
//        long start = System.currentTimeMillis();
//
//        // start of function
//
//        count_function(10000000);
//
//        // end of function
//
//        // ending time
//        long end = System.currentTimeMillis();
//        System.out.println("Counting to 10000000 takes " +
//                (end - start) + "ms");
//    }