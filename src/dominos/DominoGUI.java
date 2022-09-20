package dominos;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class is an addition for the graphical version of the
 * game. It extends StackPane to provide the graphical
 * representation of the dominos and to allow
 * me to stack the highlight image on top when needed.
 */

public class DominoGUI extends StackPane {
    private Domino domino;
    private ImageView imageView;
    private Display display;
    private ImageView highlightImg;

    /**
     * The constructor for the DominoGUI class
     * @param display The used instance of the Display class
     * @param domino the domino associated with the DominoGUI
     * @param imageView The ImageView of the above domino
     */
    DominoGUI(Display display, Domino domino, ImageView imageView) {
        this.display=display;
        this.domino=domino;
        this.imageView=imageView;
        this.getChildren().add(imageView);
    }

    /**
     * Getter for the domino object
     * @return The domino object
     */
    public Domino getDomino() {
        return domino;
    }

    /**
     * Setter for the highlight image
     * @param highlightImg the highlight ImageView
     */
    public void setHighlightImg(ImageView highlightImg) {
        this.highlightImg = highlightImg;
        this.getChildren().add(highlightImg);
    }

    /**
     * Getter for the highlight ImageView
     * @return The highlight ImageView
     */
    public ImageView getHighlightImg() {
        return highlightImg;
    }
}
