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
        this.board = new Board(24, game.getPlayers());
    }

    /**
     * Tests if it's possible to draw a card from the deck.
     */
    @Test
    void drawCard() {

        ChanceSquare cs = new ChanceSquare("Chance", game.getPlayers(), board);

        ChanceCard card = cs.drawCard();

        assertNotNull(card);
    }

    /**
     * Tests if the cards gets shuffled at a pseudo random level.
     * This test should fail at moments if truly random and even at a pseudo random level.
     */
    @Test
    void shuffleCards() {
        ChanceSquare cs = new ChanceSquare("Chance", game.getPlayers(), board);
        ChanceCard[] chanceCards = cs.getDeck();

        cs.shuffleCards();
        ChanceCard[] shuffledCards = cs.getDeck();

        assertNotEquals(chanceCards, shuffledCards);
    }
}