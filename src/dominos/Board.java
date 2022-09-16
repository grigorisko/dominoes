package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Domino> boneyard = new ArrayList<Domino>();
    private List<Domino> currentBoard = new ArrayList<Domino>();
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
            if(domino.getFirstNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getFirstNumber()==currentBoard.get(0).getSecondNumber()
            ||domino.getSecondNumber()==currentBoard.get(0).getFirstNumber()
            ||domino.getSecondNumber()==currentBoard.get(0).getSecondNumber()){
                return true;
            }
        }
        return false;
    }

    public boolean TryMove(Domino dominoToPlay, String side) {
        if (side.equals("l")) {
            if (currentBoard.size()==0) {
                currentBoard.add(dominoToPlay);
                return true;
            }
            else if (dominoToPlay.getSecondNumber()==
                    currentBoard.get(0).getFirstNumber()
                    ||dominoToPlay.getSecondNumber()==0
                    ||currentBoard.get(0).
                    getFirstNumber()==0) {
                currentBoard.add(0,dominoToPlay);
                return true;
            }
            else {
                return false;
            }
        }
        else if (side.equals("r")) {
            if (currentBoard.size()==0) {
                return true;
            }
            else if (dominoToPlay.getFirstNumber()==
                    currentBoard.get(currentBoard.size()-1).getSecondNumber()
                    ||dominoToPlay.getFirstNumber()==0
                    ||currentBoard.get(currentBoard.size()-1).
                    getSecondNumber()==0){
                currentBoard.add(dominoToPlay);
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

    public List<Domino> getCurrentBoard() {
        return currentBoard;
    }

    public void addDomino(Domino domino, int side) {
        if (side == 0) {
            currentBoard.add(0, domino);
        }
        else {
            currentBoard.add(domino);
        }
    }
}
