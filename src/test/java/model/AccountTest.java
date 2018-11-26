package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    /**Test case: TC3
     *
     * Tests that it should not be possible to for a Player's Account's totalCash to be negative after a turn has been played.
     * If it is negative, it should be changed to 0 instead.
     */
//    @Test
//    void accountNegativeTotalCashTest() {
//        Player testPlayer = new Player("testNegativeCash");
//        int startingCash = testPlayer.getTotalCash();
//
//        testPlayer.addToCash(-999);
//        int cashAfterNegativeInput = testPlayer.getTotalCash();
//        testPlayer.addToCash(-1);
//        int cashAtZero = testPlayer.getTotalCash();
//        testPlayer.addToCash(-10);
//        int cashAfterNegativeValue = testPlayer.getTotalCash();
//
//
//        //Checks if the Player's Account's getTotalCash starts with 1000, as it is requested
//        assertEquals(1000, startingCash);
//
//        //Checks if addToCash works when a negative cashInfluence is added and the Player's Account's totalCash does not go into the negative
//        assertEquals(1, cashAfterNegativeInput);
//
//        //Checks if addToCash works when adding a cashInfluence with the negative value of the Player's Account's totalCash
//        assertEquals(0, cashAtZero);
//
//        //Checks if addToCash stops at 0, as is requested, when adding a negative cashInfluence, which should supposedly
//        // make the Player's Account's totalCash go into the negative had no precautions for this been made.
//        assertEquals(0, cashAfterNegativeValue);
//    }
}