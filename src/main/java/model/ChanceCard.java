package model;

public abstract class ChanceCard {
    private String scenario;
//    private boolean onHand; //Flyttet til CCOutOfJail

    public ChanceCard(String scenario) {
        this.scenario = scenario;
//        this.onHand = false;
    }

    protected abstract void actOnCard(Player p);

    protected int findSquare(String squareName) {
        Board board;
        int index = board.findSquareByName(squareName);
        return index;
    }
}
