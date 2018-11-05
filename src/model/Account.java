package model;

public class Account {
    private int totalCash;

    public Account() {
        this.totalCash = 1000;
    }


    public void addToCash(int cashInfluence) {

        if(totalCash < cashInfluence) {
            this.totalCash = 0;
        }
        else {
            this.totalCash = this.totalCash+cashInfluence;
        }
    }

    public int getTotalCash() {
        return this.totalCash;
    }
}
