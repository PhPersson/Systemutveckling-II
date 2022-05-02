package gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsControllerTest {

    @Test
    void initialize() {
    }

    @Test
    void tfNameInputChange() {
    }

    @Test
    void setChangeScene() {
    }

    @Test
    void aiSliderChange() {
    }

    @Test
    void potSliderChange() {
    }

    @Test
    void cbOnClicked() {
    }

    @Test
    void cbOffClicked() {
    }

    @Test
    void startGame() {
    }

    @Test
    void startGameWindow() {
    }

    @Test
    void ivQuestionAiHovered() {
    }

    @Test
    void ivQuestionPotHovered() {
    }

    @Test
    void ivQuestionTutorialHovered() {
    }

    @Test
    void back() {
    }

    @Test
    void getName() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        SettingsController settingsController = new SettingsController();

        settingsController.setName("Testnamn");
        assertEquals("Testnamn", settingsController.getName());
    }
}