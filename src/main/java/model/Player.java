package model;

import java.util.ArrayList;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Player class and all if its fields and methods
 * Class to represent a single player throughout the game
 */
public class Player {
    private String number;  //Number of player
    private Account account;
    private int currPosition;
    private ArrayList<Square> squaresOwned;

    /**
     * Constructor for Player
     *
     * @param number    Player number
     */
    public Player(String number){
        this.account = new Account();
        this.number = number;
        currPosition = 0;
    }

    /**
     * Method to add cash unto the account of instance of Player
     *
     * @param cashInfluence
     */
    public void addToCash(int cashInfluence){
        this.account.addToCash(cashInfluence);
    }

    /**
     * Get methods of Player class.
     */
    public int getTotalCash() {
        return account.getTotalCash();
    }
    public String getNumber(){
        return number;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void updateCurrPosition(int position) {
        this.currPosition = position;
    }

    public void addOwnedSquare(Square square){
        squaresOwned.add(square);
    }

}
