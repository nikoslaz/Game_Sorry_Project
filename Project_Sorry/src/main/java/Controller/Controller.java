package Controller;

import Model.Board.*;
import Model.Cards.*;
import Model.Player.*;
import View.GraphicUI;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The Controller class manages the game logic, including player actions and state changes.
 * It initializes the cards, players, and board, and handles various game-related methods.
 *
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class Controller {

    private final ArrayList<Player> players = new ArrayList<>();
    private final Pawn[] pawns1 = new Pawn[2];
    private final Pawn[] pawns2 = new Pawn[2];
    private final Deck cards = new Deck();
    private int fold, winner;
    private boolean endGame;
    private final Board board = new Board();
    private GraphicUI graphicUI;
    private int currentPlayerIndex;

    /**
     * Constructs a new instance of Controller and initializes the cards, players, pawns, and board.
     * <p><b>Post-condition:</b> The controller has been initialized along with game elements.</p>
     */
    public Controller() {
        initializeGameElements();
    }

    /**
     * Gets the deck of cards.
     *
     * <p><b>Accessor:</b> Returns the deck of cards.</p>
     * <p><b>Post-condition:</b> Returns the deck of cards.</p>
     *
     */
    public void setGraphicUI(GraphicUI graphicUI) {
        this.graphicUI = graphicUI;
    }

    /**
     * Initializes game elements such as cards, players, pawns, and the board.
     * <p><b>Post-condition:</b> Game elements are initialized.</p>
     */
    public void initializeGameElements() {
        cards.initializeCards();

        // Initialize players
        Player p1 = new Player("Nikos", "Red", 1);
        Player p2 = new Player("Laz", "Yellow", 2);

        // Initialize Pawn objects for Player 1
        for (int i = 0; i < pawns1.length; i++) {
            pawns1[i] = new Pawn("Red") ;
        }
        pawns1[0].setPosition(20);
        pawns1[1].setPosition(21);
        pawns1[0].setActive(true);
        pawns1[1].setActive(true);
        pawns1[0].setId(0);
        pawns1[1].setId(1);

        // Initialize Pawn objects for Player 2
        for (int i = 0; i < pawns2.length; i++) {
            pawns2[i] = new Pawn("Yellow");
        }
        pawns2[0].setPosition(234);
        pawns2[1].setPosition(235);
        pawns2[0].setActive(true);
        pawns2[1].setActive(true);
        pawns2[0].setId(3);
        pawns2[1].setId(4);

        // Set pawns to players
        p1.setPawns(pawns1);
        p2.setPawns(pawns2);

        // Add players to the list
        players.add(p1);
        players.add(p2);

        // Initialize other game elements
        fold = 0;
        winner = 0;
        endGame = false;
        currentPlayerIndex = 0; // Start with the first player (index 0)
        board.initializeBoard();
    }


    /**
     * Checks if both pawns of a player are on the home square, indicating that the game has finished.
     *
     * <p><b>Accessor:</b> Returns true if the game has finished; false otherwise.</p>
     * <p><b>Post-condition:</b> Returns true if both pawns of a player are on the home square; false otherwise.</p>
     *
     * @return true if the game has finished; false otherwise
     */
    public boolean hasPlayerFinished() {
        // Home positions for red and yellow pawns
        int redHomePosition = 6 * 16 + 2; // Row 6, Column 2
        int yellowHomePosition = 10 * 16 + 13; // Row 10, Column 13

        // Determine the home position based on the current player's color
        int homePosition = getCurrentPlayer().getColor().equals("Red") ? redHomePosition : yellowHomePosition;

        // Retrieve the pawns of the current player
        Pawn[] pawns = getCurrentPlayer().getPawns();

        // Check if both pawns are on their home square
        return (pawns[0].getPosition() == homePosition && pawns[1].getPosition() == homePosition);
    }

    /**
     * Moves a pawn from one position to another on the board.
     *
     * <p><b>Transformer:</b> Moves a pawn from one position to another on the board.</p>
     * <p><b>Post-condition:</b> Moves a pawn from one position to another on the board.</p>
     *
     * @param pawn      the pawn to move
     * @param position the  position for the pawn
     */
    public void movePawn(Pawn pawn, int position, int cardValue) {
        // Validate pawn and board
        if (pawn == null) {
            System.out.println("Pawn or board is null");
            return;
        }

        int newPosition = getNewPosition(pawn, position, cardValue);
        Square currentSquare = board.getSquare(position);
        Square newSquare = board.getSquare(newPosition);

        // Validate squares
        if (currentSquare == null || newSquare == null) {
            System.out.println("One of the squares is null");
            return;
        }

        // Update the squares
        currentSquare.setOccupied(false);
        newSquare.setOccupied(true);

        // Update pawn's position
        pawn.setPosition(newPosition);
        // Next players turn
        nextTurn();
        // Check if player has won

        // Update UI and game state as necessary
        graphicUI.updateUI(pawn, position, newPosition);
    }

    /**
     * Calculates a pawn's new position on the game board.
     *
     * <p><b>Function:</b> Determines the new position of a pawn based on its current position, the value of a drawn card, and the pawn's color. This method incorporates game logic such as special starting positions, slides, and movement towards home. It also checks if the new position is occupied, and if so, retains the pawn's original position.</p>
     * <p><b>Post-condition:</b> Returns the new position of the pawn, or the original position if the new position is occupied.</p>
     *
     * @param pawn the pawn to move
     * @param position the current position of the pawn
     * @param cardValue the value of the drawn card
     * @return int the new position of the pawn, or the original position if the new one is occupied
     */
    private int getNewPosition(Pawn pawn, int position, int cardValue) {
        // Validate input
        if (pawn == null) {
            System.out.println("Pawn or board is null");
            return position;
        }

        int newPosition = position;
        int boardSize = 16; // Assuming a square board with 16 squares per side

        int row = position / boardSize;
        int col = position % boardSize;

        // Handle starting positions for different colored pawns
        switch (pawn.getColor()) {
            case "Red":
                if (position == 20 || position == 21) {
                    if (cardValue == 1) {
                        row = 0;
                        col = 4;
                    }
                    else if(cardValue == 2){
                        row = 0;
                        col = 5;
                    }
                }
                break;
            case "Yellow":
                if(position == 234 || position == 235){
                    if(cardValue == 1){
                        row = 15;
                        col = 10;
                    }
                    else if(cardValue == 2){
                        row = 15;
                        col = 11;
                    }
                }
                break;
        }

        // Move the pawn based on card value
        newPosition = calculateNewPosition(row, col, cardValue, boardSize);

        // Check for slides and other special rules
        newPosition = applySpecialRules(newPosition);

        // Check if the new position goes towards home
        newPosition = checkIfGoingToHome(newPosition);

        // Check if the new position is occupied
        if (board.getSquare(newPosition).isOccupied()) {
            return position; // Return original position if new position is occupied
        }

        return newPosition;
    }

    /**
     * Calculates a new position on the board based on current position and card value.
     *
     * <p><b>Function:</b> Adjusts the position of a pawn on the game board based on the value of a drawn card. The movement can be forward for most card values, but specifically backward for a card value of 4.</p>
     * <p><b>Post-condition:</b> Returns the new position of the pawn after applying the movement logic based on the card value.</p>
     *
     * @param row the current row of the pawn on the board
     * @param col the current column of the pawn on the board
     * @param cardValue the value of the drawn card
     * @param boardSize the size of the game board
     * @return int the new position of the pawn on the board
     */
    private int calculateNewPosition(int row, int col, int cardValue, int boardSize) {
        // Card value 4
        if(cardValue != 4){
            for (int i = 0; i < cardValue; i++) {
                // Forward movement
                if (row == 0 && col < boardSize - 1) {
                    col++; // Move right on the top row
                } else if (col == boardSize - 1 && row < boardSize - 1) {
                    row++; // Move down on the right column
                } else if (row == boardSize - 1 && col > 0) {
                    col--; // Move left on the bottom row
                } else if (col == 0 && row > 0) {
                    row--; // Move up on the left column
                }
            }
        }else {
            // Backward movement for card value 4
            if (row == 0 && col > 0) {
                col--; // Move left on the top row
            } else if (col == boardSize - 1 && row > 0) {
                row--; // Move up on the right column
            } else if (row == boardSize - 1 && col < boardSize - 1) {
                col++; // Move right on the bottom row
            } else if (col == 0 && row < boardSize - 1) {
                row++; // Move down on the left column
            }
        }
        return row * boardSize + col;
    }

    /**
     * Applies special movement rules to a pawn's position based on the game's rules.
     *
     * <p><b>Function:</b> Alters the pawn's position according to specific game rules for slides, differing for red and yellow pawns. This method checks the pawn's current position and color, then adjusts the position if it lands on a slide start point.</p>
     * <p><b>Post-condition:</b> Returns the new position of the pawn after applying the special rules.</p>
     *
     * @param newPosition the current position of the pawn before applying the special rules
     * @return int the new position of the pawn after applying the special rules
     */
    private int applySpecialRules(int newPosition) {
        // Implement logic for slides if pawn is red
        if(Objects.equals(getCurrentPlayer().getColor(), "Red")){
            if(newPosition == 31){
                newPosition = 79;
            }
            else if(newPosition == 80){
                newPosition = 32;
            }
            else if(newPosition == 224){
                newPosition = 160;
            }
            else if(newPosition == 127){
                newPosition = 191;
            }
            else if(newPosition == 246){
                newPosition = 242;
            }
            else if(newPosition == 254){
                newPosition = 251;
            }
        }
        // Implement logic for slides if pawn is yellow
        else{
            if(newPosition == 1){
                newPosition = 4;
            }
            else if(newPosition == 9){
                newPosition = 13;
            }
            if(newPosition == 31){
                newPosition = 79;
            }
            else if(newPosition == 80){
                newPosition = 32;
            }
            else if(newPosition == 224){
                newPosition = 160;
            }
            else if(newPosition == 127){
                newPosition = 191;
            }
        }

        return newPosition;
    }

    /**
     * Calculates the new position for a pawn as it approaches its home area.
     *
     * <p><b>Function:</b> Determines the next position for a pawn based on its current position and color, specifically when nearing the home area. This includes logic for yellow and red pawns approaching their respective homes.</p>
     * <p><b>Post-condition:</b> Returns the calculated position considering the pawn's movement towards its home.</p>
     *
     * @param newPosition the current position of the pawn
     * @return int the new position of the pawn as it moves towards its home
     */
    private int checkIfGoingToHome(int newPosition) {
        int boardSize = 16;
        int row = newPosition / boardSize;
        int col = newPosition % boardSize;

        String currentPlayerColor = getCurrentPlayer().getColor();

        // Check if the yellow pawn should start moving upwards towards its home
        if ("Yellow".equals(currentPlayerColor) && (row == 0 && (col == 14 || col == 15))) {
            // Move upwards towards home (row 10, column 13)
            row++;
            col = 13;
        }
        // Check if the red pawn should start moving downwards towards its home
        else if ("Red".equals(currentPlayerColor) && (row == 0 && (col >= 0 && col <= 3))) {
            // Move downwards towards home (row 6, column 2)
            row++;
            col = 2;
        }

        return row * boardSize + col;
    }


    /**
     * Determines if the game has ended, either due to a winner or a draw.
     *
     * <p><b>Observer:</b> Returns true if the game has ended; false otherwise.</p>
     * <p><b>Post-condition:</b> Returns true if the game has ended; false otherwise.</p>
     *
     * @return true if the game has ended; false otherwise
     */
    public boolean hasGameEnded() {
        // Check if the game has ended due to a winner
        if (hasPlayerFinished()) {
            // Set the winner
            winner = currentPlayerIndex;

            // Set the end game flag
            endGame = true;

            return true;
        }
        return false;
    }

    /**
     * Gets the current turn's player.
     *
     * <p><b>Accessor:</b> Returns the current turn's player.</p>
     * <p><b>Post-condition:</b> Returns the current turn's player.</p>
     *
     * @return the current turn's player
     */
    public Player getCurrentPlayer() {
        if (players.isEmpty() || currentPlayerIndex < 0) {
            return null;
        }
        if(currentPlayerIndex % 2 == 0) {
            return players.get(0);
        }
        else {
            return players.get(1);
        }
    }

    /**
     * If a player presses the fold button, it increases the variable fold (fold++) or sets the variable fold to 0
     * if a round finished, and gives the turn to the next player.
     *
     * <p><b>Transformer:</b> Increases the fold variable (fold++) or sets the fold to 0 if a round finished.</p>
     * <p><b>Post-condition:</b> Increases the fold variable or sets it to 0 and gives the turn to the next player.</p>
     */
    public void setFold() {
        // If this is the first fold (no player has folded in this round yet)
        if (fold == 0) {
            // Pass the turn to the next player
            nextTurn();
        }

        // Increment the fold count (0 -> 1 for the first fold, 1 -> 2 for the second)
        fold++;

        // If both players have folded consecutively (fold count reaches 2)
        if (fold == 2) {
            // Reset the fold count for the next round
            fold = 0;
        }
    }


    /**
     * Makes changes after a round started based on the provided cards' positions.
     *
     * <p><b>Transformer:</b> Makes changes after a round started.</p>
     * <p><b>Post-condition:</b> Makes changes after a round started.</p>
     *
     * @param cardsPosition the positions of the cards played in the round
     */
    public void makeChanges(ArrayList<Integer> cardsPosition) {
        // TODO:
    }

    /**
     * Advances the game to the next player's turn.
     *
     * <p><b>Transformer:</b> Increments the index representing the current player, effectively moving the turn to the next player.</p>
     * <p><b>Post-condition:</b> The game's current player index is incremented, updating the turn to the next player.</p>
     */
    public void nextTurn() {
        currentPlayerIndex ++;
    }
}
