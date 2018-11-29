package model.squareTypes;

import model.Player;

public class PropertySquare extends Square{

    private int price;
    private int rentPrice;
    private final String color;  //Todo enum list? https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    private Player owner;
    private boolean isOwned;
    private String playerAction;

    public PropertySquare(String scenario, int price, int rentPrice, String color){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;
        this.color = color;
        this.owner = null;
        isOwned = false;
    }

    //TODO rent og buy metoder
    @Override
    public void landedOn(Player p) {
        if(isOwned && !p.equals(owner)){
            //TODO KNA: Proper method for rent, must control if player owns a set.
            buyProperty(p);

        } else if(!isOwned){
            p.addToCash(-price);
            this.owner = p;
            p.addOwnedSquare(this);
        }
    }

    private void buyProperty(Player p){
        p.addToCash(-rentPrice);
        owner.addToCash(rentPrice);
        playerAction = p.getName() + " bought a " + super.toString() + " for " + price + "M";
    }

    private void payRent(Player p){
        playerAction = p.getName() + " bought a " + super.toString() + " for " + price + "M";
    }

    @Override
    public String toString() {
        return playerAction;
    }
}


