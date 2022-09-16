package dominos;

public class Main {
    private Board board = new Board();
    private Player humanPlayer = new Player(true, 1);
    private Player computerPlayer = new Player(false, 2);
    private GameState gameState = new GameState();
    private KeyboardInput keyboardInput = new KeyboardInput();
    private TextCom textCom = new TextCom(humanPlayer,computerPlayer, keyboardInput);
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        board.initializeDominos();
        for (Domino domino:board.getBoneyard()) {
            System.out.println(domino.getFirstNumber() + "," +domino.getSecondNumber()+ " ");
        }
        humanPlayer.drawAtStart(board);
        computerPlayer.drawAtStart(board);
        for (Domino domino:humanPlayer.getPlayerHand()) {
            System.out.println(domino.getFirstNumber() + "," +domino.getSecondNumber()+ " ");
        }
        while(!isGameOver()) {
            textCom.nextTurn(gameState,board);
        }

    }

    public boolean isGameOver() {
        return false;
    }
}
