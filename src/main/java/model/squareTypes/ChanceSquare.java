package model.squareTypes;

import model.Player;
import model.chanceCardTypes.ChanceCard;

import java.util.ArrayList;

public class ChanceSquare extends Square {


    protected ChanceCard[] chanceCards;

    public ChanceSquare(String scenario){
        super(scenario);
        chanceCards = new ChanceCard[18];
    }
    //Todo skal implementeres
    private void initChanceCards(){

    }

    @Override
    public void landedOn(Player p) {

        // Todo getRandomCard skal implementeres
        int index = getRandomCard();
        chanceCards[index].actOnCard(p);

    }
}
