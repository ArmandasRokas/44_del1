package model.chanceCardTypes;

import model.Player;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the CCOutOfJail class and all of its fields and methods
 * Class to represent the "Get out of jail"-card of the game
 */
public class CCOutOfJail extends ChanceCard {
//    private boolean onHand;
//TODO opret metode til onHand, så flere spillere ikke kan trække det samme kort samtidigt. > Kommer til at gøre ting ved blandingen af kort også. Skal også implementeres i 'draw' så flere ikke trækker det

    /**
     * Constructor of CCOutOfJail
     *
     * @param scenario  Scenario of the card
     */
    public CCOutOfJail(String scenario) {
        super(scenario);
//        this.onHand = false;
    }

    /**
     * Gives the card to the player that have drawn the card, by incrementing an int on Player
     *
     * @param p Player to be affected by the card
     */
    public void actOnCard(Player p) {
//        this.onHand = true;
        p.giveOutOfJailCard();
    }
}