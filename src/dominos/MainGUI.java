package dominos;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainGUI {
    private Board board = new Board();
    private Player humanPlayer = new Player(true, 1);
    private Player computerPlayer = new Player(false, 2);
    private GameState gameState = new GameState();
    private Display display;

    public static void main (String [] args ) {
        Application.launch(Display.class, args);
    }

    public void start(Display display) {
        board.initializeDominos();
        humanPlayer.drawAtStart(board);
        computerPlayer.drawAtStart(board);
        this.display=display;
    }
    public boolean isGameOver() {
        if(board.getBoneyard().isEmpty()) {
            if (gameState.getTurnsWithoutPlay() == 2) {
                checkWinner();
                return true;
            }
            else if (gameState.getWhoseTurn()==1) {
                if(computerPlayer.getPlayerHand().isEmpty()
                   && !board.checkForAvailableMove(humanPlayer)){
                    checkWinner();
                    return true;
                }
            }
            else if (gameState.getWhoseTurn()==2) {
                if(humanPlayer.getPlayerHand().isEmpty()
                   && !board.checkForAvailableMove(computerPlayer)) {
                    checkWinner();
                    return true;
                }
            }
        }
        return false;
    }

    private void checkWinner() {
        int playerScore = 0;
        int computerScore = 0;
        Text endGameText = new Text();
        endGameText.setFont(new Font(50));
        endGameText.setTranslateX(100);
        endGameText.setTranslateY(190);
        for(Domino domino:humanPlayer.getPlayerHand()) {
            playerScore += domino.getFirstNumber();
            playerScore += domino.getSecondNumber();
        }
        for(Domino domino:computerPlayer.getPlayerHand()) {
            computerScore += domino.getFirstNumber();
            computerScore += domino.getSecondNumber();
        }
        if(playerScore<computerScore) {
            endGameText.setText("Congratulations! You won!\n" +
                    "Your dots: " + playerScore +"\n" +
                    "Computer's dots: " + computerScore);

        }
        else if(playerScore>computerScore) {
            endGameText.setText("You lost!\n" +
                    "Your dots: " + playerScore +"\n" +
                    "Computer's dots: " + computerScore);
        }
        else if(playerScore==computerScore) {
            if(gameState.getLastPlayer()==1) {
                endGameText.setText("Congratulations! You won" +
                        " because you were the last to play a domino\n" +
                        "Your dots: " + playerScore +"\n" +
                        "Computer's dots: " + computerScore);
            }
            else {
                endGameText.setText("You lost! The computer played" +
                        " the last domino.\n" +
                        "Your total dots: " + playerScore +"\n" +
                        "Computer's total dots: " + computerScore);
            }
        }
        display.getPane().getChildren().clear();
        display.getPane().getChildren().add(endGameText);
    }

    public Board getBoard() {
        return board;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getComputerPlayer() {
        return computerPlayer;
    }

    public GameState getGameState() {
        return gameState;
    }
}
