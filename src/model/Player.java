package model;

/**@author Hold 44
 * @version 11/10-2018
 *
 * Defines Player class and all if its attributes
 */
public class Player {
    private String number;  //Number of player
    private Account account;

    /**
     * Constructor for player
     *
     * @param number    Player number
     */
    public Player(String number){
        this.account = new Account();
        this.number = number;
    }

    /**
     * Get and set methods of total score and method for adding to score.
     *
     * @return  total score of Player
     */
    public int getTotalCash() {
        return account.getTotalCash();
    }

    public void addToCash(int cashInfluence){
        this.account.addToCash(cashInfluence);
    }

    /**
     * Get method of player number
     *
     * @return  player number
     */
    public String getNumber(){
        return number;
    }
}
