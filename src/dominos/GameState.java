package dominos;

public class GameState {
    private int whoseTurn = 1;
    private int turnsWithoutPlay = 0;
    private int lastPlayer;

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    public int getTurnsWithoutPlay() {
        return turnsWithoutPlay;
    }

    public void setTurnsWithoutPlay(int turnsWithoutPlay) {
        this.turnsWithoutPlay = turnsWithoutPlay;
    }

    public int getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(int lastPlayer) {
        this.lastPlayer = lastPlayer;
    }
}
