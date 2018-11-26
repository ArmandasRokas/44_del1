package model;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines the Account class and its field and methods
 * Class to represent and act on the account of a player throughout the game
 */
public class Account {
    private int totalCash;

    /**
     * Constructor of Account class
     */
    public Account() {
        this.totalCash = 1000; //TODO skal omskrives til 20 for 2 spillere, 18 for 3 spillere, 16 for 4 spillere.
    }

    /**
     * Adds to the current amount of cash the player currently have stashed. If negative value it will detract instead
     * Sets the amount of cash to zero if it has reached below
     *
     * @param cashInfluence Positive or negative amount to be added to the players account
     */
    public void addToCash(int cashInfluence) {
        this.totalCash = this.totalCash + cashInfluence;
        if(this.totalCash < 0) {
            this.totalCash = 0;
        }

        }

    /**
     * Get method of totalCash
     *
     * @return  Amount of cash currently stashed by the player
     */
    public int getTotalCash() {
        return this.totalCash;
    }

    //TODO Skal nok have forbindelse til en tilsvarende metode i Player, som kan tjekke om spilleren har passeret start i Board.
    public void moneyForPassingStart() {

    }



}
