package dominos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class contains the handlers for the mouse input
 * of the GUI version.
 */
public class MouseInput {
    private Domino domino;
    private Board board;
    private Display display;
    private DominoGUI dominoGUI;

    private GameState gameState;

    /**
     * Constructor for the MouseInput class
     * @param board The board
     * @param display The display
     * @param gameState The game state
     */
    public MouseInput(Board board, Display display, GameState gameState) {
        this.board = board;
        this.display = display;
        this.gameState = gameState;
    }

    /**
     * Handler for clicking on a domino
     * in the player's hand
     * @return event
     */
    public EventHandler<MouseEvent> selectDomino() {
        return event -> {
            if(dominoGUI!=null) {
                dominoGUI.getChildren().remove(dominoGUI.getHighlightImg());
            }
            this.dominoGUI = (DominoGUI) event.getSource();
            domino = dominoGUI.getDomino();
            display.selectDomino(domino, dominoGUI);
        };
    }

    /**
     * Handler for clicking on the Draw From Boneyard
     * button.
     * @return event
     */
    public EventHandler<MouseEvent>drawFromBoneyard() {
        return event -> {
            display.drawFromBoneyard();
        };
    }

    /**
     * Handler for clicking on the Rotate button
     * @return event
     */
    public EventHandler<MouseEvent>rotateDomino(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.rotateDomino(domino);
            }
        };
    }
    /**
     * Handler for clicking on the Play On Left button
     * @return event
     */
    public EventHandler<MouseEvent>playOnLeft(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.playDomino(domino, "l");
            }
        };
    }

    /**
     * Handler for clicking on the Play On Right button
     * @return event
     */
    public EventHandler<MouseEvent>playOnRight(Domino domino) {
        return event -> {
            if(gameState.getWhoseTurn()==1) {
                display.playDomino(domino, "r");
            }
        };
    }

}
