package model.AllSquares;

import model.Player;

public class PropertySquare extends Square{

    private int price;
    private int rentPrice;
    private Player owner;
    private boolean isOwned;

    public PropertySquare(String scenario, int price, int rentPrice){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;
        this.owner = null;
        isOwned = false;

    }

    //TODO hvis spilleren selv ejer feltet, skal spilleren ikke betale rente.
    @Override
    public void landedOn(Player p) {

        if(isOwned){
           p.addToCash(-rentPrice);
        } else {
            p.addToCash(-price);
            owner = p;
            p.addOwnedSquare(this);
        }
    }
}


