package model;

/**@author Hold 44
 * @version 11/10-2018
 *
 * Defines Player class and all if its attributes
 */
public class Player {
    private int totalCash; //Totalscore of player
    private String number;  //Number of player

    /**
     * Constructor for player
     *
     * @param number    Player number
     */
    public Player(String number){
        this.totalCash = 0;
        this.number = number;
    }

    /**
     * Get and set methods of total score and method for adding to score.
     *
     * @return  total score of Player
     */
    public int getTotalCash() {
        return totalCash;
    }
    public void setTotalCash(int totalCash){
        this.totalCash = totalCash;
    }
    public int addToCash(int roll){
        this.totalCash = totalCash + roll;
        return totalCash;
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
