package wordpic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;

public class HistoryController {

    @FXML
    private Label correctLabel;

    @FXML
    private Label wrongLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label motivationalLabel;

    @FXML
    private Button retryButton;

    @FXML
    private Button menuButton;

    @FXML
    private Button soundButton;

    private boolean soundOn = true;
    private AudioClip clickSound;

    @FXML
    public void initialize() {
      
        motivationalLabel.setText("¡Bien hecho!");

       
        clickSound = new AudioClip(getClass().getResource("/sounds/click.mp3").toString());
    }

    public void setResults(int correct, int wrong, String totalTime) {
        correctLabel.setText(String.valueOf(correct));
        wrongLabel.setText(String.valueOf(wrong));
        timeLabel.setText(totalTime);

      
        if (correct > wrong) {
            motivationalLabel.setText("¡Excelente trabajo!");
        } else if (correct == wrong) {
            motivationalLabel.setText("¡Sigue practicando!");
        } else {
            motivationalLabel.setText("¡No te rindas!");
        }
    }

    @FXML
    private void handleRetry() {
        System.out.println("Reintentar juego");
      
    }

    @FXML
    private void handleMenu() {
        System.out.println("Volver al menú principal");
       
    }

    @FXML
    private void handleSound() {
        soundOn = !soundOn;
        if (soundOn) {
            soundButton.setText("🔊");
            clickSound.play();
        } else {
            soundButton.setText("🔇");
        }
    }
}
