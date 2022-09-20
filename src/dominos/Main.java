package dominos;
/**
 * Name: Vasileios Grigorios Kourakos
 * The main class for the command line version of the game.
 * Has the game loop, checks if the game is over
 * and checks who the winner is.
 */
public class Main {
    private Board board = new Board();
    private Player humanPlayer = new Player(true, 1);
    private Player computerPlayer = new Player(false, 2);
    private GameState gameState = new GameState();
    private KeyboardInput keyboardInput = new KeyboardInput();
    private static Main main;
    private TextCom textCom =
            new TextCom(humanPlayer,computerPlayer, keyboardInput);

    /**
     * The main method of the program.
     * Creates a new non static instance of Main
     * and runs it.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        main = new Main();
        main.start();
    }

    /**
     * The method used to run the non-static main object.
     * Initializes the board, players and starts the game
     * loop
     */
    public void start() {
        board.initializeDominos();
        humanPlayer.drawAtStart(board);
        computerPlayer.drawAtStart(board);
        while(!isGameOver()) {
            textCom.nextTurn(gameState,board);
        }
    }

    /**
     * This method checks to see if the game is over
     * If not, continue the game loop
     * @return True if over, false if not
     */
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

    /**
     * This method checks who the winner is based on the
     * number of dots on the dominos of each player's hand.
     * Also prints out the game ending messages.
     */
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
