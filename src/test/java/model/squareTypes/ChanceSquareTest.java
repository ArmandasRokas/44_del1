package model.squareTypes;

import controller.GameController;
import model.GameBoard;
import model.chanceCardTypes.ChanceCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceSquareTest {
    GameController gameController;
    GameBoard gameBoard;

    @BeforeEach
//    void BeforeEach() {
//        this.gameController = new GameController(4);
//        this.gameBoard = gameController.getGameBoard();
//    }

    /**Test case: TC3
     *
     * Tests if the cards gets shuffled at a pseudo random level.
     * !This test should fail at moments if truly random and even at a pseudo random level!
     *
     */
    @Test
    void shuffleCardsTest() {
        ChanceSquare cs = new ChanceSquare("Chance", gameController.getPlayers(), gameBoard);
        ChanceCard[] chanceCards = cs.getDeck();

        cs.shuffleCards();
        ChanceCard[] shuffledCards = cs.getDeck();

        assertNotEquals(chanceCards, shuffledCards);
    }

    /**Test case: TC4
     *
     * Tests if it's possible to draw a card from the deck.
     */
    @Test
    void drawCardTest() {

        ChanceSquare cs = new ChanceSquare("Chance", gameController.getPlayers(), gameBoard);

        ChanceCard card = cs.drawCard();

        assertNotNull(card);
    }
}