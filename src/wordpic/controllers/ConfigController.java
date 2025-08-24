package wordpic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class ConfigController {

    @FXML
    private ComboBox<String> languageCombo;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Button saveBtn;

    // Dificultad seleccionada
    private String selectedDifficulty = "MEDIO";

    // Actividad seleccionada
    private String selectedActivity = "SELECCIÓN MÚLTIPLE";

    @FXML
    public void initialize() {
        // Opciones de idioma
        languageCombo.getItems().addAll("Español", "Inglés", "Francés");
        languageCombo.setValue("Español"); // valor por defecto

        // Configuración inicial de volumen
        volumeSlider.setValue(50);

        // Acción de guardar
        saveBtn.setOnAction(event -> guardarConfiguracion());
    }

    @FXML
    private void setDificultadFacil() {
        selectedDifficulty = "FÁCIL";
    }

    @FXML
    private void setDificultadMedio() {
        selectedDifficulty = "MEDIO";
    }

    @FXML
    private void setDificultadDificil() {
        selectedDifficulty = "DIFÍCIL";
    }

    @FXML
    private void setActividadSeleccion() {
        selectedActivity = "SELECCIÓN MÚLTIPLE";
    }

    @FXML
    private void setActividadEmparejamiento() {
        selectedActivity = "EMPAREJAMIENTO";
    }

    @FXML
    private void setActividadCompletar() {
        selectedActivity = "COMPLETAR PALABRA";
    }

    private void guardarConfiguracion() {
        String idioma = languageCombo.getValue();
        double volumen = volumeSlider.getValue();

        System.out.println("⚙ Configuración guardada:");
        System.out.println("Dificultad: " + selectedDifficulty);
        System.out.println("Actividad: " + selectedActivity);
        System.out.println("Idioma: " + idioma);
        System.out.println("Volumen: " + volumen);

        // Aquí puedes llamar a tu DataManager o un SettingsManager para guardar en archivo/json/db
        // DataManager.saveConfig(selectedDifficulty, selectedActivity, idioma, volumen);
    }
}
