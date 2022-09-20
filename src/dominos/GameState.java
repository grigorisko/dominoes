package dominos;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class contains information about the
 * current state of the game.
 * Tracks whose turn it is, who was the last
 * player to play a domino successfully,
 * and how many turns it has been without
 * any moves.
 */
public class GameState {
    private int whoseTurn = 1;
    private int turnsWithoutPlay = 0;
    private int lastPlayer;

    /**
     * Getter for whose turn it is
     * @return Whose turn it is
     */
    public int getWhoseTurn() {
        return whoseTurn;
    }

    /**
     * Setter for whose turn it is
     * @param whoseTurn Whose turn it is
     */
    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    /**
     * Getter for how many turns without play
     * @return How many turns without play
     */
    public int getTurnsWithoutPlay() {
        return turnsWithoutPlay;
    }

    /**
     * Setter for how many turns without play
     * @param turnsWithoutPlay How many turns without play
     */
    public void setTurnsWithoutPlay(int turnsWithoutPlay) {
        this.turnsWithoutPlay = turnsWithoutPlay;
    }

    /**
     * Getter for last player to make a move
     * @return Last player to make a move
     */
    public int getLastPlayer() {
        return lastPlayer;
    }

    /**
     * Setter for last player to make a move
     * @param lastPlayer Last player to make a move
     */
    public void setLastPlayer(int lastPlayer) {
        this.lastPlayer = lastPlayer;
    }
}
