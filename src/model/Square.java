package model;

public class Square {
    private String scenario;
    private int cashInfluence;


    public Square(String scenario, int cashInfluence) {
        this.scenario = scenario;
        this.cashInfluence = cashInfluence;
    }


    public String getScenario() {
        return scenario;
    }


    public int getCashInfluence() {
        return cashInfluence;
    }

}
