package model.chanceCardTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the CCMoneyInfluence class and all of its fields and methods
 * Class to represent the cards of the game that have influence one or more players of the game
 */
public class CCMoneyInfluence extends ChanceCard {
    private int moneyInfluence;         //Amount of the players balance there is to be influenced
    private boolean actOnOtherPlayers;  //Boolean to determine if it affects other players
    private Player[] players;           //List of players

    /**
     * Constructor of CCMoneyInfluence
     *
     * @param scenario          Scenario description of the card
     * @param moneyInfluence    Amount of the players balance there is to be affected by the card
     * @param actOnOtherPlayers Boolean if cards affects other players
     * @param players           List of players in game
     */
    public CCMoneyInfluence(String scenario, int moneyInfluence, boolean actOnOtherPlayers, Player[] players) {
        super(scenario);
        this.moneyInfluence = moneyInfluence;
        this.actOnOtherPlayers = actOnOtherPlayers;
        this.players = players;
    }

    /**
     * Affects the player(s) balance as determined by card
     *
     * @param currPlayer    Main player to be affected by card
     */
    @Override
    public void actOnCard(Player currPlayer) {
        if(actOnOtherPlayers) {
            int moneyCollected = 0;

            for(int index = 0; index < players.length ; index++) {
                if(!players[index].equals(currPlayer)) {
                    moneyCollected += moneyInfluence;
                    players[index].addToCash(-moneyInfluence); //TODO Name doesn't make sense now. I argue for renaming to something like "influenceCash".
                }
            }

            currPlayer.addToCash(moneyCollected);
        }
        else{
            currPlayer.addToCash(moneyInfluence);
        }
    }
}