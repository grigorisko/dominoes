package dominos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseInput {
    private Domino domino;
    private Board board;
    private Display display;
    private DominoGUI dominoGUI;

    private GameState gameState;

    public MouseInput(Board board, Display display, GameState gameState) {
        this.board = board;
        this.display = display;
        this.gameState = gameState;
    }

    public EventHandler<MouseEvent> selectDomino() {
        return event -> {
            if(dominoGUI!=null) {
                dominoGUI.getChildren().remove(dominoGUI.getHighlightImg());
            }
            this.dominoGUI = (DominoGUI) event.getSource();
            domino = dominoGUI.getDomino();
            display.SelectDomino(domino, dominoGUI);
        };
    }

    public EventHandler<MouseEvent>drawFromBoneyard() {
        return event -> {
            display.DrawFromBoneyard();
        };
    }

    public EventHandler<MouseEvent>rotateDomino(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.RotateDomino(domino);
            }
        };
    }
    public EventHandler<MouseEvent>playOnLeft(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.PlayDomino(domino, "l");
            }
        };
    }
    public EventHandler<MouseEvent>playOnRight(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.PlayDomino(domino, "r");
            }
        };
    }

}
