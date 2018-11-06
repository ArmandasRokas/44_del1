package model;

public class Account {
    private int totalCash;

    public Account() {
        this.totalCash = 1000;
    }


    public void addToCash(int cashInfluence) {
        this.totalCash = this.totalCash + cashInfluence;
        if(this.totalCash < 0) {
            this.totalCash = 0;
        }


//        if(totalCash < (0 - cashInfluence) && cashInfluence < 0) {
//            this.totalCash = 0;
//        }
//        else {
//            this.totalCash = this.totalCash+cashInfluence;
//        }
    }

    public int getTotalCash() {
        return this.totalCash;
    }
}
