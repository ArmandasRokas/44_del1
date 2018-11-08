package model;

/**
 * Class to represent the squares on which the players land on when they roll the dices
 */
public class Square {
    private String scenario;
    private int cashInfluence;
    private boolean extraTurn;

    /**
     * Genereal constructor of the squares on the game
     *
     * @param scenario      String to be printed when a player lands on it
     * @param cashInfluence int to determine the effect when a player lands on it
     */
    public Square(String scenario, int cashInfluence) {
        this.scenario = scenario;
        this.cashInfluence = cashInfluence;
        this.extraTurn = false;
    }

    /**
     * Constructor to give specific instances of squares the ability to grant extra turns
     *
     * @param scenario      String to be printed when a player lands on it
     * @param cashInfluence int to determine the effect when a player lands on it
     * @param extraTurn     boolean to grant extra turns to player when the square is landed on
     */
    public Square(String scenario, int cashInfluence, boolean extraTurn) {
        this.scenario = scenario;
        this.cashInfluence = cashInfluence;
        this.extraTurn = extraTurn;
    }

    /**
     * Get methods of Square class
     */
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