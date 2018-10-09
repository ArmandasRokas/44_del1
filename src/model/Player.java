package model;

public class Player {
    private int totalScore;
    private String name;
    //Constructor
    public Player(String name){
        this.totalScore = 0;
        this.name = name;
    }
    //Methods

    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore){
        this.totalScore = totalScore;
    }
    public int addToScore(int roll){
        this.totalScore = totalScore + roll;
        return totalScore;
    }
    public String getName(){
        return name;
    }

}
