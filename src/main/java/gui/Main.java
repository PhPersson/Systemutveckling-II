package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main method to start the program.
 * 
 * @author Lykke Levin
 * @version 1.0
 *
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

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				Platform.exit();
				System.exit(0);
			}
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
