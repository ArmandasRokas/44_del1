package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    //TODO Test case navn / nummerering
    /**
     * Test case: TC###
     *
     * Tests that it should not be possible to for a Player's Account's totalCash to be negative after a turn has been played.
     * If it is negative, it should be changed to 0 instead.
     */
    @Test
    void accountNegativeTotalCashTest() {
        Player testPlayer = new Player("testNegativeCash");
        int startingCash = testPlayer.getTotalCash();

        testPlayer.addToCash(-999);
        int cashAfterNegativeInput = testPlayer.getTotalCash();
        testPlayer.addToCash(-1);
        int cashAtZero = testPlayer.getTotalCash();
        testPlayer.addToCash(-10);
        int cashAfterNegativeValue = testPlayer.getTotalCash();

        assertEquals(1000, startingCash);
        assertEquals(1, cashAfterNegativeInput);
        assertEquals(0, cashAtZero);
        assertEquals(0, cashAfterNegativeValue);
    }
}