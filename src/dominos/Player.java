package dominos;

import java.util.ArrayList;
import java.util.List;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class represents the players of the game.
 * Contains the player hand, and the ways to
 * manipulate it (draw from boneyard, play domino etc.)
 */
public class Player {
    private List<Domino> playerHand = new ArrayList<Domino>();
    private boolean isRealPlayer;
    private int playerNum;

    /**
     * The Player constructor
     * @param isRealPlayer If it is the human or computer player
     * @param playerNum 1 for human 2 for computer
     */
    public Player(boolean isRealPlayer, int playerNum) {
        this.isRealPlayer = isRealPlayer;
        this.playerNum = playerNum;
    }

    /**
     * Initialization method that draws 7 dominos
     * from the boneyard
     * @param board The board to draw from.
     */
    public void drawAtStart(Board board) {
        for (int i=0; i<7; i++) {
            playerHand.add(board.getBoneyard().remove(0));
        }
    }

    /**
     * This method draws a domino from the boneyard
     * @param board The board to draw from
     */
    public void drawFromBoneyard(Board board) {
        playerHand.add(board.getBoneyard().remove(0));
    }

    /**
     * This method is only used for the computer player turn,
     * and simply finds the first available domino move and
     * plays it. I didn't code any smarter play because it
     * was not required.
     * @param board The board of play
     * @param gameState The game state
     */
    public void playComputerDomino(Board board, GameState gameState) {
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
            playComputerDomino(board, gameState);
        }
        else {
            gameState.setWhoseTurn(1);
            gameState.setTurnsWithoutPlay(gameState.getTurnsWithoutPlay()+1);
        }
    }

    /**
     * Getter for the player's hand
     * @return The player's hand
     */
    public List<Domino> getPlayerHand() {
        return playerHand;
    }
}
