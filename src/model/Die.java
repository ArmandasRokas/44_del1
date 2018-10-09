package model;

public class Die {
    //Variables
    private int eyes;
    //Constructor
    public Die(){
       this.eyes = 1;
    }
    //Methods

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        if(1 <= eyes && eyes <= 6) {
            this.eyes = eyes;
        }
        else {
            System.out.println("Error");
        }
    }
}
