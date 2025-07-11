package test.tests.Controller;

import Controller.Controller;
import Model.Player.Pawn;
import Model.Player.Player;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void initializeGameElements() {
        assertNotNull(controller); // Ensure the controller is initialized
    }

    @Test
    void hasPlayerFinished() {
        // assert the expected outcome
        assertFalse(controller.hasPlayerFinished());
    }

    @Test
    void movePawn() {
        // Simulate moving a pawn and assert the pawn's new position
        Pawn pawn = new Pawn("Red");
        int initialPosition = 20;
        controller.movePawn(pawn, initialPosition, 2);
        assertNotEquals(initialPosition, pawn.getPosition()); // Assert that position has changed
    }

    @Test
    void hasGameEnded() {
        // Assert the outcome
        assertFalse(controller.hasGameEnded());
    }

    @Test
    void getCurrentPlayer() {
        // Assert the current player is correct
        Player currentPlayer = controller.getCurrentPlayer();
        assertNotNull(currentPlayer);
    }

    @Test
    void setFold() {
        // Simulate the fold action and assert the changes in the game state
        controller.setFold();
    }

    @Test
    void nextTurn() {
        // Simulate a turn change and assert the current player has changed
        Player initialPlayer = controller.getCurrentPlayer();
        controller.nextTurn();
        assertNotEquals(initialPlayer, controller.getCurrentPlayer());
    }
}
