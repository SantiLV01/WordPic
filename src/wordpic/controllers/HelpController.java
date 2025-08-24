package wordpic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelpController {

    @FXML
    private Button menuButton;

    @FXML
    private Button soundButton;

    @FXML
    private Button helpButton;

    @FXML
    private void initialize() {
       
        menuButton.setOnAction(e -> {
            System.out.println("Volviendo al Menú Principal...");
           
        });

      
        soundButton.setOnAction(e -> {
            System.out.println("Botón de sonido presionado 🎵");
           
        });

       
        helpButton.setOnAction(e -> {
            System.out.println("Estás en la sección de ayuda.");
        });
    }
}
