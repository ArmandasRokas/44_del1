package model.chanceCardTypes;

import controller.Game;
import model.Player;

public class CCMoneyInfluence extends ChanceCard {
    private int moneyInfluence;
    private boolean actOnOtherPlayers;

    public CCMoneyInfluence(String scenario, int moneyInfluence, boolean actOnOtherPlayers) {
        super(scenario);
        this.moneyInfluence = moneyInfluence;
        this.actOnOtherPlayers = actOnOtherPlayers;
    }

    @Override
    public void actOnCard(Player currPlayer) {
        if(actOnOtherPlayers) {
            Game game; //FixMe Needs a way to get the playerList from Game
            Player playerList[] = game.getPlayerList();
            int moneyCollected = 0;

            for(int index = 0; index < playerList.length ; index++) {
                if(!playerList[index].equals(currPlayer)) {
                    moneyCollected += moneyInfluence;
                    playerList[index].addToCash(-moneyInfluence); //TODO Name doesn't make sense now. I argue for renaming to something like "influenceCash".
                }
            }

            currPlayer.addToCash(moneyCollected);
        }
        else{
            currPlayer.addToCash(moneyInfluence);
        }
    }
}