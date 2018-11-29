package model;

public class Cup {

    private Die d1, d2;

    public Cup(){
        this.d1 = new Die(1,6);
        this.d2 = new Die(1,6);
    }

    public void roll(){
        d1.rollDie();
        d2.rollDie();
    }

    /**
     * Addd the eyes of the two dices
     *
     * @return  Sum of the two dices
     */
    public int getCurrentRollScore() {
        return d1.getEyes() + d2.getEyes();
    }
}
