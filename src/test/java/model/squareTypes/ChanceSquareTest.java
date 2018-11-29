package model.squareTypes;

import controller.Game;
import model.Board;
import model.chanceCardTypes.ChanceCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceSquareTest {
    Game game;
    Board board;

    @BeforeEach
    void BeforeEach() {
        this.game = new Game(4);
        this.board = game.getBoard();
    }

    /**Test case: TC3
     *
     * Tests if the cards gets shuffled at a pseudo random level.
     * !This test should fail at moments if truly random and even at a pseudo random level!
     *
     */
    @Test
    void shuffleCardsTest() {
        ChanceSquare cs = new ChanceSquare("Chance", game.getPlayers(), board);
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

        ChanceSquare cs = new ChanceSquare("Chance", game.getPlayers(), board);

        ChanceCard card = cs.drawCard();

        assertNotNull(card);
    }
}