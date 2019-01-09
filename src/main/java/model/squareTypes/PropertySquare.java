package model.squareTypes;

import model.Player;
import ui.Abstract_UI;

import java.util.ArrayList;

/**@author Hold 44
 * @version 30/11-2018
 *
 * Defines the PropertySquare class and its field and methods
 * Class to represent the "Property"-squares of the board
 */
public class PropertySquare extends Square{

    private int price;                      //Price of the property
    private int[] rentPrice;                  //Price of landing on the property
    //Todo color: enum list? https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    private final int groupID;
    private Player owner;                   //Reference to the player that owns the property
    private boolean isOwned;                //Boolean to determine if the property is owned
    private ArrayList<PropertySquare> siblingSquares;   //Reference to the other property of same color
    private Abstract_UI gui_boundary;
    private int index;
    private int numberOfHouses;

    /**
     * Constructor of PropertySquare
     *
     * @param scenario  Name of the property
     * @param price     Price of the property
     * @param rentPrice Price of landing on the property
     * @param color     Color group of the property
     */
    public PropertySquare(String scenario, int[] rentPrice, int price, int groupID, int index, Abstract_UI gui_boundary){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;
        this.groupID = groupID;
        this.owner = null;
        isOwned = false;
        this.gui_boundary = gui_boundary;
        this.index = index;
        siblingSquares = new ArrayList<>();
        this.numberOfHouses = 0;
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
        } else if (isOwned && p.equals(owner)){
          super.playerAction = p.getName() + " står på " + super.toString() +
                  " som " + p.getName() + " ejer selv.";
        } else if(!isOwned){

            boolean userAnswer = gui_boundary.askToBuyProperty();
            if(userAnswer){
                buyProperty(p);
            }
        }
    }

    /**
     * Checks if the other properties of same colors are owned
     *
     * @return  Boolean as true if player owns a set
     */
    public boolean isPropertySetOwned() {
        boolean res = false;

   //     if(owner.equals(siblingSquare.getOwner())) {
   //         res = true;
   //     }
        return res;
    }

    /**
     * Pays the owner of the property with the cash owed by the player landing on it
     *
     * @param p Player who have landed on the property
     */

    private void payRent(Player p){
        int toBePayed = rentPrice[0]; //TODO checks how many houses are on field and change rent price
        //TODO Create test for this if-statement
        if(isPropertySetOwned()) {
            toBePayed = toBePayed * 2;
        }
        p.addToCash(-toBePayed);
        owner.addToCash(toBePayed);
        super.playerAction = p.getName() + " står på " + super.toString() + ", som ejes af " + owner.getName() +
                ". Du har betalt " + toBePayed + "DKK til " + owner.getName();
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
        super.playerAction = p.getName() + " købt " + toString();
        gui_boundary.setOwnerOnSquare(p.getName(), this.index);
    }

    /**
     * toString method of PropertySquare
     *
     * @return  Scenario of the square
     */
    @Override
    public String toString() {

        if(owner == null){
            return super.scenario + " for " + price + "dkk";
        } else {
            return super.scenario;
        }

    }

    /**
     * Get method for the color of the property
     *
     * @return  Color of the property
     */
    public int getGroupID() {
        return groupID;
    }

    /**
     * Links the property sets by color group
     *
     * @param ps    Property it is to have a reference to
     */
    public void setSiblingSquare(PropertySquare ps) {
        siblingSquares.add(ps);
    }

    /**
     * Get method for the owner of the property
     *
     * @return  Owner of the property
     */
    public Player getOwner() {
        return owner;
    }

    public boolean canBuild(){

        for(PropertySquare propertySquare: siblingSquares){
            if(!propertySquare.getOwner().equals(owner)){
                return false;
            }
        }
        return true;
    }

    public void buildHouse(){
        numberOfHouses++;
    }

    /**
     * Method is used for test
     *
     * @return
     */

    public ArrayList<PropertySquare> getSiblingSquares(){

        return siblingSquares;

    }




}