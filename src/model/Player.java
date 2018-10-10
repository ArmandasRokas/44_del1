package model;

public class Player {
    private int totalScore;
    private String number;
    //Constructor
    public Player(String number){
        this.totalScore = 0;
        this.number = number;
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
    public String getNumber(){
        return number;
    }

}
