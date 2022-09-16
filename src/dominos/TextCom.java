package dominos;

public class TextCom {
    private Player humanPlayer;
    private Player computerPlayer;
    private KeyboardInput keyboardInput;
    public TextCom(Player humanPlayer, Player computerPlayer, KeyboardInput keyboardInput) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.keyboardInput = keyboardInput;
    }
    public void nextTurn(GameState gameState, Board board){
        if (gameState.getWhoseTurn()==1) {
            System.out.println("Computer has "+computerPlayer.getPlayerHand().size() + " dominos");
            System.out.println("Boneyard contains " + board.getBoneyard().size() + " dominos");
            for(Domino domino: board.getCurrentBoard()) {
                System.out.print("[" + domino.getFirstNumber() + " "
                        + domino.getSecondNumber() + "]" + " ");
            }
            System.out.print("Player hand: ");
            for(Domino domino: humanPlayer.getPlayerHand()) {
                System.out.print("[" + domino.getFirstNumber() + " "
                        + domino.getSecondNumber() + "]" + " ");
            }
            System.out.println();
            System.out.println("Human's turn");
            System.out.println("[p] Play domino");
            System.out.println("[d] Draw from boneyard");
            System.out.println("[q] Quit");
            String input = keyboardInput.getPlayerInput();
            if(input.equals("p")) {
                System.out.println("Which domino?");
                String dominoNum = keyboardInput.getPlayerInput();
                int dominoInput = Integer.parseInt(dominoNum);
                if (dominoInput
                        <=humanPlayer.getPlayerHand().size()) {
                    Domino dominoToPlay =
                            humanPlayer.getPlayerHand().get(dominoInput);
                    System.out.println("Left or right? (l/r)");
                    String side = keyboardInput.getPlayerInput();
                    if(side.equals("l") || side.equals("r")) {
                        System.out.println("Rotate first? (y/n)");
                        String rotate = keyboardInput.getPlayerInput();
                        if (rotate.equals("y") || rotate.equals("n")) {
                            if (rotate.equals("y")) {
                                int left = dominoToPlay.getFirstNumber();
                                int right = dominoToPlay.getSecondNumber();
                                dominoToPlay.setFirstNumber(right);
                                dominoToPlay.setSecondNumber(left);
                            }
                            if(board.TryMove(dominoToPlay, side)) {
                                humanPlayer.getPlayerHand().remove(dominoInput);
                                gameState.setLastPlayer(1);
                                gameState.setTurnsWithoutPlay(0);
                                gameState.setWhoseTurn(2);
                            }
                            else {
                                System.out.println("Incorrect move. Try again");
                                nextTurn(gameState,board);
                            }
                        }
                        else {
                            System.out.println("Wrong input. Try again");
                        }
                    }
                    else {
                        System.out.println("Wrong input. Try again");
                        nextTurn(gameState,board);
                    }
                }
                else {
                    System.out.println("Wrong number. Try again");
                    nextTurn(gameState,board);
                }

            }
            else if(input.equals("d")) {
                if (board.checkForAvailableMove(humanPlayer)) {
                    System.out.println(
                            "Can't draw when there is an available move"
                    );
                }
                else {
                    humanPlayer.getPlayerHand().add(board.getBoneyard().remove(0));
                    nextTurn(gameState,board);
                }
            }
            else if(input.equals("q")) {
                System.out.println("Terminating program");
                System.exit(0);
            }
        }
        else if(gameState.getWhoseTurn()==2) {
            computerPlayer.PlayDomino(board, gameState);
        }
    }
}
