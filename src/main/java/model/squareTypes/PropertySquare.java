package model.squareTypes;

import model.Player;

public class PropertySquare extends Square{

    private int price;
    private int rentPrice;
    private final String color;  //Todo enum list? https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    private Player owner;
    private boolean isOwned;

    public PropertySquare(String scenario, int price, int rentPrice, String color){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;
        this.color = color;
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


