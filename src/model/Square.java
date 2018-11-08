package model;

public class Square {
    private String scenario;
    private int cashInfluence;
    private boolean extraTurn;

    //TODO Beslut om vi skal have to constructors her eller bare bruge den ene.
    public Square(String scenario, int cashInfluence) {
        this.scenario = scenario;
        this.cashInfluence = cashInfluence;
        this.extraTurn = false;
    }

    public Square(String scenario, int cashInfluence, boolean extraTurn) {
        this.scenario = scenario;
        this.cashInfluence = cashInfluence;
        this.extraTurn = extraTurn;
    }

    public String getScenario() {
        return scenario;
    }

    public int getCashInfluence() {
        return cashInfluence;
    }

    public boolean checkExtraTurn() {
        return extraTurn;
    }

}
