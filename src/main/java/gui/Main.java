package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * Main method to start the program.
 *
 * @author Lykke Levin
 * @version 1.0
 */

public class Main extends Application {
    public static Stage window;
    public ChangeScene cs = new ChangeScene();

    /**
     * The applications calls start(Stage primaryStage) after launch has been
     * executed.
     */
    public void start(Stage primaryStage) throws Exception {
        cs.prepGame();

        window = primaryStage;
        window.setTitle("TeachMePoker");
        window.setResizable(true);

        /**
         * Closes the window and exits the program.
         */
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Close");
            alert.setHeaderText("Close program?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get() != ButtonType.OK){
                event.consume();
                return;
            }

            Platform.exit();
            System.exit(0);
        });

        window.setScene(cs.firstScene());
        window.show();

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
