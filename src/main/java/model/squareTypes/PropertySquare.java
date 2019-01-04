package model.squareTypes;

import model.Player;

import java.awt.*;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the PropertySquare class and its field and methods
 * Class to represent the "Property"-squares of the board
 */
public class PropertySquare extends Square{

    private int price;                      //Price of the property
    private int rentPrice;                  //Price of landing on the property
    //Todo color: enum list? https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
//    private final String color;             //Color group of the property
    private final Color color;             //Color group of the property
    private Player owner;                   //Reference to the player that owns the property
    private boolean isOwned;                //Boolean to determine if the property is owned
    private PropertySquare siblingSquare;   //Reference to the other property of same color
    private String playerAction;            //String to print what happened on the property

    /**
     * Constructor of PropertySquare
     *
     * @param scenario  Name of the property
     * @param price     Price of the property
     * @param rentPrice Price of landing on the property
     * @param color     Color group of the property
     */
//    public PropertySquare(String scenario, int price, int rentPrice, String color){
//        super(scenario);
//        this.price = price;
//        this.rentPrice = rentPrice;
//        this.color = color;
//        this.owner = null;
//        isOwned = false;
//    }
    public PropertySquare(String scenario, int price, int rentPrice, Color color){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;
        this.color = color;
        this.owner = null;
        isOwned = false;
    }

    /**
     * Acts the scenario of landing on the property on the player who landed on it
     *
     * @param p Instance of player who have landed on the square
     */
    @Override
    public void landedOn(Player p) {
        if(isOwned && !p.equals(owner)){
            payRent(p);
        } else if(!isOwned){
            buyProperty(p);
        }
    }

    /**
     * Checks if the other properties of same colors are owned
     *
     * @return  Boolean as true if player owns a set
     */
    public boolean isPropertySetOwned() {
        boolean res = false;

        if(owner.equals(siblingSquare.getOwner())) {
            res = true;
        }
        return res;
    }

    /**
     * Pays the owner of the property with the cash owed by the player landing on it
     *
     * @param p Player who have landed on the property
     */
    private void payRent(Player p){
        int toBePayed = rentPrice;
        //TODO Create test for this if-statement
        if(isPropertySetOwned()) {
            toBePayed = toBePayed * 2;
        }
        p.addToCash(-toBePayed);
        owner.addToCash(toBePayed);
        playerAction = p.getName() + " is on " + super.toString() + " which is owned by " + owner.getName() +
                " You paid " + toBePayed + "M to" + owner.getName();
    }

    /**
     * Buys the property to the player and links them for future references
     *
     * @param p Player who have landed on the property
     */
    private void buyProperty(Player p){
        p.addToCash(-price);
        this.owner = p;
        this.isOwned = true;
        p.addOwnedSquare(this);
        playerAction = p.getName() + " bought a " + super.toString() + " for " + price + "M";
    }

    /**
     * toString method of PropertySquare
     *
     * @return  Scenario of the square
     */
    @Override
    public String toString() {
        return playerAction;
    }

    /**
     * Get method for the color of the property
     *
     * @return  Color of the property
     */
//    public String getColor() {
//        return color;
//    }
    public Color getColor() {
        return color;
    }

    /**
     * Links the property sets by color group
     *
     * @param ps    Property it is to have a reference to
     */
    public void setSiblingSquare(PropertySquare ps) {
        this.siblingSquare = ps;
    }

    /**
     * Get method for the owner of the property
     *
     * @return  Owner of the property
     */
    public Player getOwner() {
        return owner;
    }

    public int getPrice() { return price; }
}