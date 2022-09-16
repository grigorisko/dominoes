package dominos;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Domino> playerHand = new ArrayList<Domino>();
    private boolean isRealPlayer;
    private int playerNum;

    public Player(boolean isRealPlayer, int playerNum) {
        this.isRealPlayer = isRealPlayer;
        this.playerNum = playerNum;
    }
    public void drawAtStart(Board board) {
        for (int i=0; i<7; i++) {
            playerHand.add(board.getBoneyard().remove(0));
        }
    }

    public void drawFromBoneyard(Board board) {
        playerHand.add(board.getBoneyard().remove(0));
    }

    public void PlayDomino(Board board, GameState gameState) {
        int boardSize = board.getCurrentBoard().size();
        Domino lastDomino = board.getCurrentBoard().get(boardSize-1);
        for (Domino domino:playerHand) {
            if (domino.getFirstNumber()==lastDomino.getSecondNumber()
                || domino.getFirstNumber()==0) {
                board.addDomino(domino, 1);
                getPlayerHand().remove(domino);
                gameState.setLastPlayer(2);
                gameState.setTurnsWithoutPlay(0);
                gameState.setWhoseTurn(1);
                return;
            }
            else if (domino.getSecondNumber()==board.getCurrentBoard().
                    get(0).getFirstNumber()
                    || domino.getSecondNumber()==0) {
                board.addDomino(domino,0);
                getPlayerHand().remove(domino);
                gameState.setLastPlayer(2);
                gameState.setTurnsWithoutPlay(0);
                gameState.setWhoseTurn(1);
                return;
            }
        }
        if(!board.getBoneyard().isEmpty()) {
            drawFromBoneyard(board);
            PlayDomino(board, gameState);
        }
        else {
            gameState.setWhoseTurn(1);
            gameState.setTurnsWithoutPlay(gameState.getTurnsWithoutPlay()+1);
        }
    }
    public List<Domino> getPlayerHand() {
        return playerHand;
    }
}
