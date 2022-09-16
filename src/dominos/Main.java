package dominos;

public class Main {
    private Board board = new Board();
    private Player humanPlayer = new Player(true, 1);
    private Player computerPlayer = new Player(false, 2);
    private GameState gameState = new GameState();
    private KeyboardInput keyboardInput = new KeyboardInput();
    private static Main main;
    private TextCom textCom = new TextCom(humanPlayer,computerPlayer, keyboardInput);
    public static void main(String[] args) {
        main = new Main();
        main.start();
    }

    public void start() {
        board.initializeDominos();
        humanPlayer.drawAtStart(board);
        computerPlayer.drawAtStart(board);
        while(!isGameOver()) {
            textCom.nextTurn(gameState,board);
        }
    }

    public boolean isGameOver() {
        if(board.getBoneyard().isEmpty()) {
            if (gameState.getTurnsWithoutPlay() == 2) {
                checkWinner();
                return true;
            }
            else if (gameState.getWhoseTurn()==1) {
                if(computerPlayer.getPlayerHand().isEmpty()){
                    checkWinner();
                    return true;
                }
            }
            else if (gameState.getWhoseTurn()==2) {
                if(humanPlayer.getPlayerHand().isEmpty()) {
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
        for(Domino domino:humanPlayer.getPlayerHand()) {
            playerScore += domino.getFirstNumber();
            playerScore += domino.getSecondNumber();
        }
        for(Domino domino:computerPlayer.getPlayerHand()) {
            computerScore += domino.getFirstNumber();
            computerScore += domino.getSecondNumber();
        }
        System.out.println("Player total: " + playerScore);
        System.out.println("Computer total: " + computerScore);
        if(playerScore<computerScore) {
            System.out.println("Congratulations! You won!");
        }
        else if(playerScore>computerScore) {
            System.out.println("You lost!");
        }
        else if(playerScore==computerScore) {
            if(gameState.getLastPlayer()==1) {
                System.out.println("Congratulations! You won" +
                        " because you were the last to play a domino");
            }
            else {
                System.out.println("You lost! The computer played" +
                        " the last domino.");
            }
        }
    }
}
