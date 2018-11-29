package model.squareTypes;

import model.Board;
import model.Cup;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertySquareTest {

    /**Test case: TC5
     *
     * Tests if the property is bought when a player lands on it
     *
     */
    @Test
    void landedOnPropertyBuyTest() {
        // Arrange
        Board b = new Board(24, true);
        Cup c = new Cup();
        Player p1 = new Player("1", b, c);
        PropertySquare propertySquare = new PropertySquare("test", 10, 5, "blue" );
        int expectedCashAfterLandedOnProperty = p1.getTotalCash() - 10;
        int expectedSquaresOwned = 1;

        // Act
        propertySquare.landedOn(p1);
        int actualCashAfterLandedOnProperty = p1.getTotalCash();
        int actualSquaresOwned = p1.getTotalSquareOwned();
        Player owner = propertySquare.getOwner();

        // Assert
        assertEquals(expectedCashAfterLandedOnProperty, actualCashAfterLandedOnProperty);
        assertEquals(expectedSquaresOwned, actualSquaresOwned);
        assertEquals(p1, owner);
    }
}