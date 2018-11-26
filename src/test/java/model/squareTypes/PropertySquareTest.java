package model.squareTypes;

import model.Board;
import model.Cup;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertySquareTest {

    @Test
    void landedOnTest() {

        // Arrange
        Board b = new Board(24, true);
        Cup c = new Cup();
        Player p1 = new Player("1", b, c);
        Square propertySquare = new PropertySquare("test", 10, 5, "blue" );
        int expectedCashAfterLandedOnProperty = p1.getTotalCash() - 10;
        int expectedSquaresOwned = 1;

        // Act
        propertySquare.landedOn(p1);
        int actualCashAfterLandendOnProperty = p1.getTotalCash();

        // Assert

        assertEquals(expectedCashAfterLandedOnProperty, actualCashAfterLandendOnProperty);
        assertEquals(expectedSquaresOwned, p1.getTotalSquareOwned());

    }
}