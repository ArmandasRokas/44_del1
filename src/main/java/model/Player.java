package model;

/**@author Hold 44
 * @version 08/11-2018
 *
 * Defines Player class and all if its fields and methods
 * Class to represent a single player throughout the game
 */
public class Player {
    private String number;  //Number of player
    private Account account;

    /**
     * Constructor for Player
     *
     * @param number    Player number
     */
    public Player(String number){
        this.account = new Account();
        this.number = number;
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
}
