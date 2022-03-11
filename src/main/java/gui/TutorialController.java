package gui;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Tutorial state.
 *
 * @author Vedrana Zeba
 */
public class TutorialController {
    @FXML
    private ImageView imgTutorial;
    @FXML
    private Pane tutorialPane;

    private int tutorialProgress = 1;
    public SettingsController settingsController;
    public GameController gameController;
    public Stage window = new Stage();
    private int gc;

    /**
     * Creates the tutorial window object, does not show the window.
     *
     * @param settingsController settingsController-object (self)
     */
    public TutorialController(SettingsController settingsController, int nr) {
        gc = nr;
        this.settingsController = settingsController;
    }

    /**
     * Creates the tutorial window object, does not show the window.
     *
     * @param gameController gameController-object (self)
     */
    public TutorialController(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * In order to prevent crash (fx:controller in Tutorial.fxml)
     */
    public TutorialController() {
    }

    /**
     * Initializes the tutorial window and all UI objects. Loads tutorial.fxml and starts the "button-listener" for next.
     * If the user cancels the tutorial mid-way, the user is sent to the game state.
     *
     * @throws IOException
     */
    public void setupUI(boolean inGame) throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tutorial");
        window.setWidth(1285);
        window.setHeight(730);
        if (inGame) {
            window.setOnCloseRequest(e -> window.close());
        } else {
            window.setOnCloseRequest(e -> settingsController.startGameWindow());
        }
        this.tutorialPane = (Pane) FXMLLoader.load(RuleController.class.getResource("/Tutorial.fxml"));
        Scene scene = new Scene(tutorialPane);
        window.setScene(scene);
        window.show();

        placeImg();
    }

    /**
     * Activates correct listener based on tutorialProgress. There are 17 steps, the last step launches the game.
     */
    public void placeImg() {
        mainImageSetup(1280, 720, true, true);

        if (tutorialProgress < 17) {
            buttonSetup("nastaButton", 170, 95, true, true, 1090, 570.5).setOnMouseReleased(mouseEvent -> {
                tutorialProgress++;
                placeImg();
            });
        } else {
            buttonSetup("spelaButton", 170, 95, true, true, 1090, 570.5).setOnMouseReleased(mouseEvent -> {
                if (gc == 1) {
                    settingsController.startGameWindow();
                }

                window.close();
            });
        }

        if (tutorialProgress > 1) {
            buttonSetup("backButtonTutorial", 170, 95, true, true, 1090, 500).setOnMouseReleased(mouseEvent -> {
                if (tutorialProgress > 1) {
                    tutorialProgress = tutorialProgress - 1;
                }
                placeImg();
            });
        }
    }

    private void mainImageSetup(double width, double height, boolean preserveRatio, boolean smooth) {
        tutorialPane.requestLayout();
        Image image = new Image(Paths.get("resources/images/tutorial" + tutorialProgress + ".png").toUri().toString(), width, height, preserveRatio, smooth);
        imgTutorial = new ImageView(image);
        tutorialPane.getChildren().add(imgTutorial);
    }

    /**
     * Adds a button to the tutorial window.
     *
     * @param buttonName Name of the button, used to get image for the button.
     * @param width      Width of the button.
     * @param height     height of the button.
     * @param x          X-coordinate of the button.
     * @param y          Y-coordinate of the button.
     * @return The button.
     */
    private ImageView buttonSetup(String buttonName, double width, double height, boolean preserveRatio, boolean smooth, double x, double y) {
        Image image = new Image(Paths.get("resources/images/" + buttonName + ".png").toUri().toString(), width, height, preserveRatio, smooth);
        ImageView button = new ImageView(image);
        button.setX(x);
        button.setY(y);
        tutorialPane.getChildren().add(button);

        return button;
    }
}
