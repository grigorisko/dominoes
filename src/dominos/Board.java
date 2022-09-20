package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class represents the board of the game.
 * Contains the boneyard.
 * Contains the logic to check for available moves,
 * add a domino to the board on each side.
 * Also tracks row placement for each domino
 * for graphical representation.
 */
public class Board {
    private List<Domino> boneyard = new ArrayList<Domino>();
    private List<Domino> currentBoard = new ArrayList<Domino>();
    private int nextLeftRow = 0;
    private int nextRightRow = 0;
    private int counter = 0;

    /**
     * This method creates the 28 dominos for play,
     * adds them to the boneyard and shuffles it
     * for randomness.
     */
    public void initializeDominos() {
        for (int i=0; i<7; i++) {
            for (int j=counter; j<7; j++) {
                Domino domino = new Domino(i,j);
                boneyard.add(domino);
            }
            counter++;
        }
        Collections.shuffle(boneyard);
    }

    /**
     * This method checks whether a player can make a move
     * based on the current board status.
     * @param player The player to check
     * @return True if there is a move, false if not
     */
    public boolean checkForAvailableMove(Player player) {
        if(currentBoard.size()==0) {
            return true;
        }
        for(Domino domino: player.getPlayerHand()) {
            if(domino.getFirstNumber()==currentBoard.get
                    (currentBoard.size()-1).getSecondNumber()
            ||domino.getSecondNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getFirstNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getSecondNumber()==currentBoard.get
                    (currentBoard.size()-1).getSecondNumber()
            ||domino.getFirstNumber()==0 || domino.getSecondNumber()==0
            ||currentBoard.get(0).getFirstNumber()==0
            ||currentBoard.get(currentBoard.size()-1).getSecondNumber()==0){
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if a specific move is valid or not.
     * @param dominoToPlay The domino to play
     * @param side The side to play the domino
     * @return True if valid, false if not
     */
    public boolean tryMove(Domino dominoToPlay, String side) {
        if (side.equals("l")) {
            if (currentBoard.size()==0) {
                currentBoard.add(dominoToPlay);
                dominoToPlay.setRow(nextLeftRow);
                dominoToPlay.setSidePlayed(0);
                flipLeftRow();
                flipRightRow();
                return true;
            }
            else if (dominoToPlay.getSecondNumber()==
                    currentBoard.get(0).getFirstNumber()
                    ||dominoToPlay.getSecondNumber()==0
                    ||currentBoard.get(0).
                    getFirstNumber()==0) {
                currentBoard.add(0,dominoToPlay);
                dominoToPlay.setRow(nextLeftRow);
                dominoToPlay.setSidePlayed(0);
                flipLeftRow();
                return true;
            }
            else {
                return false;
            }
        }
        else if (side.equals("r")) {
            if (currentBoard.size()==0) {
                currentBoard.add(dominoToPlay);
                dominoToPlay.setRow(nextRightRow);
                dominoToPlay.setSidePlayed(1);
                flipLeftRow();
                flipRightRow();
                return true;
            }
            else if (dominoToPlay.getFirstNumber()==
                    currentBoard.get(currentBoard.size()-1).getSecondNumber()
                    ||dominoToPlay.getFirstNumber()==0
                    ||currentBoard.get(currentBoard.size()-1).
                    getSecondNumber()==0){
                currentBoard.add(dominoToPlay);
                dominoToPlay.setRow(nextRightRow);
                dominoToPlay.setSidePlayed(1);
                flipRightRow();
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * Getter for the boneyard
     * @return the boneyard
     */
    public List<Domino> getBoneyard() {
        return boneyard;
    }

    /**
     * This method is used after a move
     * to swap the left side row the next domino is assigned.
     * Since we want the dominos to appear in two rows,
     * every move on the same side will have flipped rows.
     */
    public void flipLeftRow() {
        if (nextLeftRow==0) {
            nextLeftRow = 1;
        }
        else {
            nextLeftRow = 0;
        }
    }

    /**
     * This method is used after a move
     * to swap the right side row the next domino is assigned.
     * Since we want the dominos to appear in two rows,
     * every move on the same side will have flipped rows.
     */
    public void flipRightRow() {
        if (nextRightRow==0) {
            nextRightRow = 1;
        }
        else {
            nextRightRow = 0;
        }
    }

    /**
     * Getter for the domino list of the board
     * @return the currentBoard list
     */
    public List<Domino> getCurrentBoard() {
        return currentBoard;
    }

    /**
     * This method adds a domino to the board for
     * a player move.
     * @param domino The domino to add
     * @param side The side of the board to add the domino
     */
    public void addDomino(Domino domino, int side) {
        if (side == 0) {
            currentBoard.add(0, domino);
            domino.setRow(nextLeftRow);
            domino.setSidePlayed(side);
            flipLeftRow();
        }
        else {
            currentBoard.add(domino);
            domino.setRow(nextRightRow);
            domino.setSidePlayed(side);
            flipRightRow();
        }
    }
}
