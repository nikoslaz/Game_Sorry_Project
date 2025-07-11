package Model.Turn;

/**
 * Represents the turn in the game.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class Turn {
    private int currentID , turn;
    /**
     * <b>constructor</b>: Constructs a new instance of Turn and sets turn=0.
     * <b>Pre-condition</b>: The choise must be 0 or 1.
     * <b>Post-condition</b>: The turn is set.
     * @param choise
     * @param currentID
     * @param turn
     */
    public Turn() {
        this.currentID = 0;
        this.turn = 0;
    }

    /**
     * <b>transformer</b>: Sets the turn of the game.
     * <b>Post-condition</b>: The turn is set.
     * @param turn
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * <b>accessor</b>:Returns the turn of the game.
     * <b>Post-condition</b>: The turn is returned.
     * @return turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * <b>transformer</b>: Increases the turn of the game.
     * <b>Post-condition</b>: The turn is increased.
     */
    public void increaseTurn() {
        turn++;
    }

    /**
     * <b>transformer</b>: Decreases the turn of the game.
     * <b>Post-condition</b>: The turn is decreased.
     */
    public void decreaseTurn() {
        turn--;
    }

    /**
     * <b>transformer</b>: Sets the currentID of the game.
     * <b>Post-condition</b>: The currentID is set.
     * @param currentID
     */
    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }

    /**
     * <b>accessor</b>:Returns the currentID of the game.
     * <b>Post-condition</b>: The currentID is returned.
     * @return currentID
     */
    public int getCurrentID() {
        return currentID;
    }

}
