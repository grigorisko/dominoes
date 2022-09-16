package dominos;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class DominoGUI extends StackPane {
    private Domino domino;
    private ImageView imageView;
    private Display display;
    private ImageView highlightImg;
    DominoGUI(Display display, Domino domino, ImageView imageView) {
        this.display=display;
        this.domino=domino;
        this.imageView=imageView;
        this.getChildren().add(imageView);
    }

    public Domino getDomino() {
        return domino;
    }

    public void setHighlightImg(ImageView highlightImg) {
        this.highlightImg = highlightImg;
        this.getChildren().add(highlightImg);
    }

    public ImageView getHighlightImg() {
        return highlightImg;
    }
}
