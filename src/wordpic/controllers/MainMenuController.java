package wordpic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;

public class MainMenuController {

 
    @FXML private HBox topDecor;
    @FXML private HBox bottomDecor;
    @FXML private Label logoLabel;

 
    @FXML private Button playButton;
    @FXML private Button resultsButton;

 
    @FXML private Button settingsButton;
    @FXML private Button infoButton;
    @FXML private Button soundButton;

   
    @FXML private AnchorPane centerPane;

   
    private boolean soundOn = true;

    @FXML
    private void initialize() {
    
        System.out.println("MainMenu cargado ✅");

        
        playButton.setOnAction(e -> startGame());
        resultsButton.setOnAction(e -> showResults());
        settingsButton.setOnAction(e -> openSettings());
        infoButton.setOnAction(e -> showInfo());
        soundButton.setOnAction(e -> toggleSound());
    }

    private void startGame() {
        System.out.println("🎮 Iniciar juego...");
     
    }

    private void showResults() {
        System.out.println("📊 Mostrar resultados...");
      
    }

    private void openSettings() {
        System.out.println("⚙️ Abrir configuración...");
       
    }

    private void showInfo() {
        System.out.println("ℹ️ Mostrar información...");
            
    }

    private void toggleSound() {
        soundOn = !soundOn;
        soundButton.setText(soundOn ? "🔊" : "🔇");
        System.out.println("🔊 Sonido " + (soundOn ? "Activado" : "Desactivado"));
    }
}
