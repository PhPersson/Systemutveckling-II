package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.FileWriter;

/**
 * Controller for FXML-doc FirstMenu.fxml.
 *
 * @author Lykke Levin
 * @version 1.0
 */

public class FMController {
    private ChangeScene changeScene;
    private Sound sound;
    @FXML
    private TextField tfNameInput;
    @FXML
    private ImageView ivNewGame;
    @FXML
    private ImageView ivLoadGame;
    @FXML
    private ImageView ivSoundMenu;
    @FXML
    private ImageView ivSoundMenuOff;

    /**
     * Generated method for the FXML.
     *
     * @throws Exception
     */
    public void initialize() throws Exception {
        writeVolume(0.2);
        this.sound = new Sound();
        this.ivSoundMenuOff.setVisible(false);
        this.ivSoundMenuOff.setDisable(true);
    }

    /**
     * Sets the changeScene for this FMController
     *
     * @param sceneChanger an instance of the class ChangeScene
     */
    public void setChangeScene(ChangeScene sceneChanger) {
        this.changeScene = sceneChanger;

    }

    /**
     * Tells class changeScene to perform the swithScene-action.
     *
     * @throws Exception
     */
    public void NewGameClicked() throws Exception {
        changeScene.switchSceneToSetting();
    }

    /**
     * Should load a saved game file. This method is currently a non-functional
     * method that is not implemented for the final version.
     *
     * @throws IOException
     */
    public void LoadGameClicked() throws IOException {
        this.sound.playSound("wrong");
    }

    public void pauseMusic() throws InstantiationException, IllegalAccessException {
        writeVolume(0.0);
        Sound.class.newInstance().mp.setVolume(0.0);
        sound.pauseMusic();
        ivSoundMenuOff.setVisible(true);
        ivSoundMenuOff.setDisable(false);
        ivSoundMenu.setVisible(false);
        ivSoundMenu.setDisable(true);
    }

    public void playMusic() throws InstantiationException, IllegalAccessException {
        writeVolume(0.2);
        Sound.class.newInstance().mp.setVolume(0.2);
        sound.playBackgroundMusic();
        ivSoundMenu.setVisible(true);
        ivSoundMenu.setDisable(false);
        ivSoundMenuOff.setVisible(false);
        ivSoundMenuOff.setDisable(true);
    }

    public void writeVolume(double volume) {
        try {
            FileWriter myWriter = new FileWriter("resources/sounds/volume.txt");
            myWriter.write(String.valueOf(volume));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
