package model.squareTypes;

import model.Player;

public class PropertySquare extends Square{

    private int price;
    private int rentPrice;
    private final String color;  //Todo enum list? https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    private Player owner;
    private boolean isOwned;
    private PropertySquare siblingSquare;

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
            p.addToCash(-rentPrice);
            owner.addToCash(rentPrice);
        } else if(!isOwned){
            p.addToCash(-price);
            this.owner = p;
            p.addOwnedSquare(this);
        }
    }

    public boolean isPropertySetOwned() {
        boolean res = false;

        if(owner.equals(siblingSquare.getOwner())) {
            res = true;
        }
        return res;
    }

    public String getColor() {
        return color;
    }

    public void setSiblingSquare(PropertySquare ps) {
        this.siblingSquare = ps;
    }

    public Player getOwner() {
        return owner;
    }
}


