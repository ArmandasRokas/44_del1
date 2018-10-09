package controller;

import model.Die;
import model.Player;

public class Game {
    private Player p1, p2;
    private Die d1, d2;
    private Player currPlayer;

    //Constructor
    public Game(){
        this.p1 = new Player("Player 1");
        this.p2 = new Player("Player 2");

        this.d1 = new Die();
        this.d2 = new Die();

        this.currPlayer = p1;
    }

    public void play() {
        roll();
        switchPlayer();
    }

    public int randomValue() {
        return (int) Math.random()*(6 - 1 + 1) + 1;
    }

    public void addScoreToPlayer() {
        this.currPlayer.addToScore(getCurrentRollScore());

    }

    public void roll() {
        int randomValue = randomValue();
        d1.setEyes(randomValue);
        randomValue = randomValue();
        d2.setEyes(randomValue);

        addScoreToPlayer();

    }
    public int getCurrentRollScore(){
        return d1.getEyes()+d2.getEyes();

    }
    public Player getCurrentplayer(){
        return currPlayer;
    }

    public void switchPlayer(){
        if(currPlayer.equals(p1)){
            currPlayer = p2;
        }
        else if(currPlayer.equals(p2)){
            currPlayer = p1;
        }
    }
}
