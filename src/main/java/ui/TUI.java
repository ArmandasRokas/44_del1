//package ui;
//
//import model.Player;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**@author Hold 44
// * @version 30/11-2018
// *
// * Defines the TUI class and all of its fields and methods
// * Class to retrieve and show information to the players playing the game
// */
//public class TUI extends Abstract_UI {
//    Scanner scan = new Scanner(System.in);  //Scanner to retrieve inputs from players
//
//    /**
//     * Prints greeting to players
//     */
//    @Override
//    public void sayWelcome() {
//
//    }
//
//    /**
//     * Asks the players for number of players, accepts between 2-4 players
//     *
//     * @return  Amount of players
//     */
//    @Override
//    public int askForNumberOfPlayers() {
//        System.out.println("Choose 2-4 number of players: ");
//        String input = scan.nextLine();
//        switch (input.toLowerCase()){
//            case "2":
//                return 2;
//            case "3":
//                return 3;
//            case "4":
//                return 4;
//            default:
//                System.out.println("Invalid input");
//                return -1;
//        }
//    }
//
//    /**
//     * Ask the players to choose an individual name to use throughout the game
//     *
//     * @param numberOfPlayers   Number of players currently playing
//     * @return                  List of the names of players
//     */
//    public String[] askForNames(int numberOfPlayers){
//        ArrayList<String> names = new ArrayList<>();
//
//        for(int i = 0; i < numberOfPlayers; i++){
//            System.out.println("Write player name: ");
//            String input = scan.nextLine();
//            names.add(input);
//        }
//        return names;
//    }
//
//    /**
//     * Awaits players to take their turn, by putting '1' into the prompt and click [Enter] on their keyboard
//     *
//     * @return  Boolean that is true if correct input
//     */
//    @Override
//    public boolean askToTakeTurn() {
//        System.out.println(gameController.getCurrPlayerName() + " has a turn.");
//        System.out.println("Press 1 for roll dice: ");
//        String input = scan.nextLine();
//        if(input.equals("1")){
//            return true;
//        } else {
//            System.out.println("Invalid input");
//            askToTakeTurn();
//            return false;
//        }
//    }
//
//    /**
//     * Writes out the scenario to players
//     *
//     * @return  [Usage to be implemented]
//     */
//    @Override
//    public boolean showScenario() {
//        System.out.println(gameController.getCurrSquare().toString());
//        return false;
//    }
//
//    /**
//     * Prints the text on scoreboard
//     *
//     * @return  [Usage to be implemented]
//     */
//    @Override
//    public boolean updateBoardView() {
//        for (Player p: gameController.getPlayers()) {
//            System.out.println(p.toString());
//        }
//        return true;
//    }
//
//    /**
//     * Prints the final scoreboard
//     *
//     * @return  [Usage to be implemented]
//     */
//    @Override
//    public boolean showFinalResult() {
//        System.out.println("The winner is: " + gameController.getWinnerName());
//        updateBoardView();
//        return true;
//    }
//
//    /**
//     * Prints or updates the current roll
//     *
//     * @return [Usage to be implemented]
//     */
//    @Override
//    public boolean showCurrentDiesResult() {
//
//        System.out.println(gameController.getCurrPlayerName() + " rolled " + gameController.getCurrentDiesTotal());
//
//        return false;
//    }
//}
