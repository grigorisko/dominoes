package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Domino> boneyard = new ArrayList<Domino>();
    private List<Domino> currentBoard = new ArrayList<Domino>();
    private int nextLeftRow = 0;
    private int nextRightRow = 0;
    private int counter = 0;
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

    public boolean checkForAvailableMove(Player player) {
        if(currentBoard.size()==0) {
            return true;
        }
        for(Domino domino: player.getPlayerHand()) {
            if(domino.getFirstNumber()==currentBoard.get(currentBoard.size()-1).getSecondNumber()
            ||domino.getSecondNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getFirstNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getSecondNumber()==currentBoard.get(currentBoard.size()-1).getSecondNumber()
            ||domino.getFirstNumber()==0 || domino.getSecondNumber()==0
            ||currentBoard.get(0).getFirstNumber()==0
            ||currentBoard.get(currentBoard.size()-1).getSecondNumber()==0){
                return true;
            }
        }
        return false;
    }

    public boolean TryMove(Domino dominoToPlay, String side) {
        if (side.equals("l")) {
            if (currentBoard.size()==0) {
                currentBoard.add(dominoToPlay);
                dominoToPlay.setRow(nextLeftRow);
                dominoToPlay.setSidePlayed(0);
                FlipLeftRow();
                FlipRightRow();
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
                FlipLeftRow();
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
                FlipLeftRow();
                FlipRightRow();
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
                FlipRightRow();
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public List<Domino> getBoneyard() {
        return boneyard;
    }

    public void FlipLeftRow() {
        if (nextLeftRow==0) {
            nextLeftRow = 1;
        }
        else {
            nextLeftRow = 0;
        }
    }
    public void FlipRightRow() {
        if (nextRightRow==0) {
            nextRightRow = 1;
        }
        else {
            nextRightRow = 0;
        }
    }

    public List<Domino> getCurrentBoard() {
        return currentBoard;
    }

    public void addDomino(Domino domino, int side) {
        if (side == 0) {
            currentBoard.add(0, domino);
            domino.setRow(nextLeftRow);
            domino.setSidePlayed(side);
            FlipLeftRow();
        }
        else {
            currentBoard.add(domino);
            domino.setRow(nextRightRow);
            domino.setSidePlayed(side);
            FlipRightRow();
        }
    }
}
