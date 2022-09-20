package dominos;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * Name: Vasileios Grigorios Kourakos
 * This Display class extends JavaFX Application and is the
 * GUI class of my project. It creates, displays and manipulates
 * the GUI for the game.
 */
public class Display extends Application{
    //private final GridPane gridPane = new GridPane();
    private Pane pane = new Pane();
    MainGUI main = new MainGUI();

    private Board board;
    private MouseInput input;
    private GameState gameState;
    private final BufferedImage BUFFERED_IMAGE_00 = loadImage("/00.png");
    private final BufferedImage BUFFERED_IMAGE_01 = loadImage("/01.png");
    private final BufferedImage BUFFERED_IMAGE_02 = loadImage("/02.png");
    private final BufferedImage BUFFERED_IMAGE_03 = loadImage("/03.png");
    private final BufferedImage BUFFERED_IMAGE_04 = loadImage("/04.png");
    private final BufferedImage BUFFERED_IMAGE_05 = loadImage("/05.png");
    private final BufferedImage BUFFERED_IMAGE_06 = loadImage("/06.png");
    private final BufferedImage BUFFERED_IMAGE_11 = loadImage("/11.png");
    private final BufferedImage BUFFERED_IMAGE_12 = loadImage("/12.png");
    private final BufferedImage BUFFERED_IMAGE_13 = loadImage("/13.png");
    private final BufferedImage BUFFERED_IMAGE_14 = loadImage("/14.png");
    private final BufferedImage BUFFERED_IMAGE_15 = loadImage("/15.png");
    private final BufferedImage BUFFERED_IMAGE_16 = loadImage("/16.png");
    private final BufferedImage BUFFERED_IMAGE_22 = loadImage("/22.png");
    private final BufferedImage BUFFERED_IMAGE_23 = loadImage("/23.png");
    private final BufferedImage BUFFERED_IMAGE_24 = loadImage("/24.png");
    private final BufferedImage BUFFERED_IMAGE_25 = loadImage("/25.png");
    private final BufferedImage BUFFERED_IMAGE_26 = loadImage("/26.png");
    private final BufferedImage BUFFERED_IMAGE_33 = loadImage("/33.png");
    private final BufferedImage BUFFERED_IMAGE_34 = loadImage("/34.png");
    private final BufferedImage BUFFERED_IMAGE_35 = loadImage("/35.png");
    private final BufferedImage BUFFERED_IMAGE_36 = loadImage("/36.png");
    private final BufferedImage BUFFERED_IMAGE_44 = loadImage("/44.png");
    private final BufferedImage BUFFERED_IMAGE_45 = loadImage("/45.png");
    private final BufferedImage BUFFERED_IMAGE_46 = loadImage("/46.png");
    private final BufferedImage BUFFERED_IMAGE_55 = loadImage("/55.png");
    private final BufferedImage BUFFERED_IMAGE_56 = loadImage("/56.png");
    private final BufferedImage BUFFERED_IMAGE_66 = loadImage("/66.png");
    private final BufferedImage BUFFERED_HIGHLIGHT = loadImage("/highlight.png");


    private final Image IMAGE_00 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_00, null);
    private final Image IMAGE_01 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_01, null);
    private final Image IMAGE_02 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_02, null);
    private final Image IMAGE_03 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_03, null);
    private final Image IMAGE_04 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_04, null);
    private final Image IMAGE_05 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_05, null);
    private final Image IMAGE_06 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_06, null);
    private final Image IMAGE_11 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_11, null);
    private final Image IMAGE_12 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_12, null);
    private final Image IMAGE_13 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_13, null);
    private final Image IMAGE_14 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_14, null);
    private final Image IMAGE_15 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_15, null);
    private final Image IMAGE_16 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_16, null);
    private final Image IMAGE_22 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_22, null);
    private final Image IMAGE_23 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_23, null);
    private final Image IMAGE_24 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_24, null);
    private final Image IMAGE_25 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_25, null);
    private final Image IMAGE_26 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_26, null);
    private final Image IMAGE_33 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_33, null);
    private final Image IMAGE_34 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_34, null);
    private final Image IMAGE_35 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_35, null);
    private final Image IMAGE_36 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_36, null);
    private final Image IMAGE_44 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_44, null);
    private final Image IMAGE_45 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_45, null);
    private final Image IMAGE_46 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_46, null);
    private final Image IMAGE_55 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_55, null);
    private final Image IMAGE_56 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_56, null);
    private final Image IMAGE_66 = SwingFXUtils.toFXImage(BUFFERED_IMAGE_66, null);
    private final Image HIGHLIGHTIMG = SwingFXUtils.toFXImage(BUFFERED_HIGHLIGHT, null);


    private Text boneyardCount;
    private Text computerCount;
    private Button drawFromBoneyard;

    private Text playerDominos;

    /**
     * The launch method for the application. Creates all the GUI
     * elements and displays them.
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage stage) {
        main.start(this);
        board = main.getBoard();
        gameState = main.getGameState();
        input = new MouseInput(board,this, gameState);
        boneyardCount = new Text();
        boneyardCount.setFont(new Font(20));
        boneyardCount.setText("Boneyard contains "+
                board.getBoneyard().size()+" dominos");
        boneyardCount.setTranslateX(500);
        boneyardCount.setTranslateY(20);
        computerCount = new Text();
        computerCount.setFont(new Font(20));
        computerCount.setText("Computer has "+
                main.getComputerPlayer().getPlayerHand().size()+" dominos");
        computerCount.setTranslateY(50);
        computerCount.setTranslateX(500);
        playerDominos = new Text();
        playerDominos.setFont(new Font(25));
        playerDominos.setText("Your Dominos:");
        playerDominos.setTranslateX(50);
        playerDominos.setTranslateY(550);
        pane.getChildren().add(playerDominos);
        pane.getChildren().add(boneyardCount);
        pane.getChildren().add(computerCount);
        drawFromBoneyard = new Button("Draw From Boneyard");
        drawFromBoneyard.setTranslateX(1000);
        drawFromBoneyard.setTranslateY(600);
        drawFromBoneyard.setOnMouseClicked(input.drawFromBoneyard());
        pane.getChildren().add(drawFromBoneyard);
        RefreshState();
        stage.setTitle("Dominos");
        Scene scene = new Scene(pane, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method loads a buffered image from the class path
     * @param filepath The image path
     * @return The BufferedImage
     */
    private BufferedImage loadImage(String filepath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull
                    (getClass().getResourceAsStream(filepath)));
        } catch (IOException e) {
            return null;
        }
        return image;
    }

    /**
     * This method goes through the player's hand,
     * creates a DominoGUI for each domino in it
     * based on the domino numbers
     * and displays it on the screen.
     */
    public void displayPlayerHand() {
        int count = 1;
        ImageView dominoImg = null;
        for (Domino domino:main.getHumanPlayer().getPlayerHand()
        ) {
            switch(domino.getFirstNumber()){
                case 0:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_00);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_01);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_02);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_03);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_04);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_05);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_06);
                            break;
                    }
                    break;
                case 1:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_01);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_11);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_12);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_13);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_14);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_15);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_16);
                            break;
                    }
                    break;
                case 2:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_02);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_12);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_22);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_23);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_24);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_25);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_26);
                            break;
                    }
                    break;
                case 3:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_03);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_13);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_23);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_33);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_34);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_35);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_36);
                            break;
                    }
                    break;
                case 4:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_04);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_14);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_24);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_34);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_44);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_45);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_46);
                            break;
                    }
                    break;
                case 5:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_05);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_15);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_25);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_35);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_45);
                            dominoImg.setRotate(180);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_55);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_56);
                            break;
                    }
                    break;
                case 6:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_06);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_16);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_26);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_36);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_46);
                            dominoImg.setRotate(180);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_56);
                            dominoImg.setRotate(180);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_66);
                            break;
                    }
                    break;
            }
            DominoGUI dominoGUI= new DominoGUI(this, domino, dominoImg);
            dominoGUI.setTranslateX(count*65);
            dominoGUI.setTranslateY(600);
            dominoGUI.setOnMouseClicked(input.selectDomino());
            pane.getChildren().add(dominoGUI);
            count++;
        }

    }

    /**
     * This method handles the selection of a domino
     * on the player's hand when it is clicked.
     * Creates buttons for the available options,
     * and highlights the domino.
     * @param domino
     * @param dominoGUI
     */
    public void selectDomino(Domino domino, DominoGUI dominoGUI) {
        dominoGUI.setHighlightImg(new ImageView(HIGHLIGHTIMG));
        Button rotateDomino = new Button("Rotate");
        rotateDomino.setOnMouseClicked(input.rotateDomino(domino));
        rotateDomino.setTranslateY(550);
        rotateDomino.setTranslateX(1000);
        Button playLeft = new Button("Play on left");
        playLeft.setOnMouseClicked(input.playOnLeft(domino));
        playLeft.setTranslateY(510);
        playLeft.setTranslateX(1000);
        Button playRight = new Button("Play on right");
        playRight.setOnMouseClicked(input.playOnRight(domino));
        playRight.setTranslateY(470);
        playRight.setTranslateX(1000);
        pane.getChildren().add(rotateDomino);
        pane.getChildren().add(playRight);
        pane.getChildren().add(playLeft);
    }

    /**
     * This method rotates the domino when
     * the rotate button is clicked.
     * @param domino The domino to rotate.
     */
    public void rotateDomino(Domino domino) {
        int first = domino.getFirstNumber();
        int second = domino.getSecondNumber();
        domino.setFirstNumber(second);
        domino.setSecondNumber(first);
        RefreshState();
    }

    /**
     * This method tries to play the selected domino
     * when the button is clicked.
     * Displays a popup if the attempted move
     * is invalid.
     * @param domino domino to play
     * @param side side to play the domino
     */
    public void playDomino(Domino domino, String side) {
        if (board.getCurrentBoard().isEmpty()) {
            board.tryMove(domino, side);
            main.getHumanPlayer().getPlayerHand().remove(domino);
            gameState.setTurnsWithoutPlay(0);
            gameState.setWhoseTurn(2);
            gameState.setLastPlayer(1);
            RefreshState();
            if (!main.isGameOver()) {
                computerTurn();
            }
        }
        else {
            if(board.tryMove(domino,side)) {
                main.getHumanPlayer().getPlayerHand().remove(domino);
                gameState.setTurnsWithoutPlay(0);
                gameState.setWhoseTurn(2);
                gameState.setLastPlayer(1);
                RefreshState();
                if(!main.isGameOver()) {
                    computerTurn();
                }
            }
            else {
                Alert wrongMove = new Alert(Alert.AlertType.NONE,
                        "Incorrect move! Try again!", ButtonType.OK);
                wrongMove.show();
            }
        }
    }

    /**
     * This method handles the computer's turn
     * and refreshes the state of the board after.
     */
    public void computerTurn(){

        if (!board.checkForAvailableMove(main.getComputerPlayer())
                &&board.getBoneyard().size()==0) {
            gameState.setWhoseTurn(1);
            gameState.setTurnsWithoutPlay(gameState.getTurnsWithoutPlay()+1);
            main.isGameOver();
        }
        else {
            main.getComputerPlayer().playComputerDomino(board, gameState);
            RefreshState();
            main.isGameOver();
        }
    }

    /**
     * This method displays the dominos in play
     * in the middle of the screen. Contains the logic
     * to offset the rows based on information from the board
     * and each domino's row variable.
     */
    public void DisplayBoard() {
        int topRowCount = 1;
        int bottomRowCount = 1;
        int topRowOffset = 0;
        int bottomRowOffset = 0;
        if(!board.getCurrentBoard().isEmpty()) {
            if (board.getCurrentBoard().get(0).getRow() == 1) {
                topRowOffset = 30;
            } else {
                bottomRowOffset = 30;
            }
        }
        ImageView dominoImg = null;

        for (Domino domino: board.getCurrentBoard()
        ) {
            switch(domino.getFirstNumber()){
                case 0:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_00);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_01);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_02);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_03);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_04);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_05);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_06);
                            break;
                    }
                    break;
                case 1:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_01);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_11);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_12);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_13);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_14);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_15);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_16);
                            break;
                    }
                    break;
                case 2:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_02);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_12);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_22);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_23);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_24);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_25);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_26);
                            break;
                    }
                    break;
                case 3:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_03);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_13);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_23);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_33);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_34);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_35);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_36);
                            break;
                    }
                    break;
                case 4:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_04);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_14);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_24);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_34);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_44);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_45);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_46);
                            break;
                    }
                    break;
                case 5:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_05);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_15);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_25);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_35);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_45);
                            dominoImg.setRotate(180);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_55);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_56);
                            break;
                    }
                    break;
                case 6:
                    switch(domino.getSecondNumber()) {
                        case 0:
                            dominoImg = new ImageView(IMAGE_06);
                            dominoImg.setRotate(180);
                            break;
                        case 1:
                            dominoImg = new ImageView(IMAGE_16);
                            dominoImg.setRotate(180);
                            break;
                        case 2:
                            dominoImg = new ImageView(IMAGE_26);
                            dominoImg.setRotate(180);
                            break;
                        case 3:
                            dominoImg = new ImageView(IMAGE_36);
                            dominoImg.setRotate(180);
                            break;
                        case 4:
                            dominoImg = new ImageView(IMAGE_46);
                            dominoImg.setRotate(180);
                            break;
                        case 5:
                            dominoImg = new ImageView(IMAGE_56);
                            dominoImg.setRotate(180);
                            break;
                        case 6:
                            dominoImg = new ImageView(IMAGE_66);
                            break;
                    }
                    break;
            }
            DominoGUI dominoGUI= new DominoGUI(this, domino, dominoImg);
            if (domino.getRow()==0) {
                dominoGUI.setTranslateX((topRowCount*60)+topRowOffset);
                dominoGUI.setTranslateY(300);
                topRowCount++;
            }
            else if(domino.getRow()==1) {
                dominoGUI.setTranslateX((bottomRowCount*60)+bottomRowOffset);
                dominoGUI.setTranslateY(350);
                bottomRowCount++;
            }

            pane.getChildren().add(dominoGUI);

        }

    }

    /**
     * This method draws a domino from the boneyard
     * for the player when the button is clicked
     * and there is no available move.
     * If there is an available move, display a popup.
     */
    public void drawFromBoneyard() {
        if(!board.checkForAvailableMove(main.getHumanPlayer())) {
            if(!board.getBoneyard().isEmpty()) {
                main.getHumanPlayer().drawFromBoneyard(board);
                RefreshState();
                main.isGameOver();
            }
            else {
                gameState.setWhoseTurn(2);
                gameState.setTurnsWithoutPlay
                        (gameState.getTurnsWithoutPlay()+1);
                RefreshState();
                main.isGameOver();

            }
        }
        else {
            Alert wrongMove = new Alert(Alert.AlertType.NONE,
                    "Can't draw from boneyard when there are" +
                            " available moves", ButtonType.OK);
            wrongMove.show();
        }
    }

    /**
     * This method refreshes the display with the new information.
     * Updates the text, repositions the board and player hand.
     */
    public void RefreshState(){
        pane.getChildren().clear();
        DisplayBoard();
        displayPlayerHand();
        pane.getChildren().add(boneyardCount);
        pane.getChildren().add(computerCount);
        pane.getChildren().add(drawFromBoneyard);
        pane.getChildren().add(playerDominos);
        boneyardCount.setText("Boneyard contains "+board.getBoneyard().size()+" dominos");
        computerCount.setText("Computer has "+
                main.getComputerPlayer().getPlayerHand().size()+" dominos");
        main.isGameOver();
        if(gameState.getWhoseTurn()==1) {
            if (!board.checkForAvailableMove(main.getHumanPlayer())
                    && board.getBoneyard().size() == 0) {
                gameState.setWhoseTurn(2);
                gameState.setTurnsWithoutPlay(gameState.getTurnsWithoutPlay() + 1);
                if(!main.isGameOver()) {
                    computerTurn();
                }
            }
        }
    }

    /**
     * Getter for the scene Pane
     * @return the Pane
     */
    public Pane getPane() {
        return pane;
    }
}

