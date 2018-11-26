package model.AllSquares;

public class PropertySquare extends Square{

    private int price;
    private int rentPrice;

    public PropertySquare(String scenario, int price, int rentPrice){
        super(scenario);
        this.price = price;
        this.rentPrice = rentPrice;

    }

}


