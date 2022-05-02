package gui;

import de.saxsys.javafx.test.JfxRunner;
import javafx.fxml.JavaFXBuilderFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JfxRunner.class)
class GameControllerTest {

    @Test
    void setUsername() {
    }


    @Test
    void getUsername() throws Exception{
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        GameController gameController = new GameController();
        gameController.setUsername("Testnamn");
        assertEquals("Testnamn", gameController.getUsername());
    }
}