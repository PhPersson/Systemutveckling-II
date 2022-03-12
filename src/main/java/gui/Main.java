package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Main method to start the program.
 *
 * @author Lykke Levin
 * @version 1.0
 */

public class Main extends Application {
    public static Stage window;
    public ChangeScene changeScene = new ChangeScene();

    /**
     * The applications calls start(Stage primaryStage) after launch has been
     * executed.
     */
    public void start(Stage primaryStage) throws Exception {
        changeScene.prepGame();

        window = primaryStage;
        window.setTitle("TeachMePoker");
        window.setResizable(true);

        exitConfirmation(primaryStage);

        window.setScene(changeScene.firstScene());
        window.show();
    }

    /**
     * Adds a confirmation window when exiting the program.
     *
     * @param primaryStage
     */
    private void exitConfirmation(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit program");
            alert.setHeaderText("Exit?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() != ButtonType.OK) {
                event.consume();
                return;
            }

            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
