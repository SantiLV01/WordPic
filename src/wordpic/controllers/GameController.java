package wordpic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import wordpic.models.Question;
import wordpic.utils.DataManager;

import java.util.List;

public class GameController {

    @FXML
    private Label questionLabel;

    @FXML
    private Label progressLabel;

    @FXML
    private Button option1Button;

    @FXML
    private Button option2Button;

    @FXML
    private Button option3Button;

    @FXML
    private Button option4Button;

    @FXML
    private Button nextButton;

    @FXML
    private ImageView questionImageView; // Imagen de la pregunta

    private List<Question> questions;
    private int currentIndex = 0;

    @FXML
    public void initialize() {
       
        questions = DataManager.loadQuestions();

        if (questions != null && !questions.isEmpty()) {
            showQuestion(questions.get(currentIndex));
        }

     
        option1Button.setOnAction(e -> checkAnswer(option1Button.getText()));
        option2Button.setOnAction(e -> checkAnswer(option2Button.getText()));
        option3Button.setOnAction(e -> checkAnswer(option3Button.getText()));
        option4Button.setOnAction(e -> checkAnswer(option4Button.getText()));

       
        nextButton.setOnAction(e -> goToNextQuestion());
    }

    private void showQuestion(Question question) {
      
        questionLabel.setText(question.getText());

        List<String> options = question.getOptions();
        option1Button.setText(options.get(0));
        option2Button.setText(options.get(1));
        option3Button.setText(options.get(2));
        option4Button.setText(options.get(3));

        
        if (question.getImagePath() != null && !question.getImagePath().isEmpty()) {
            Image image = new Image(getClass().getResourceAsStream("/images/" + question.getImagePath()));
            questionImageView.setImage(image);
        } else {
            questionImageView.setImage(null); 
        }

    
        progressLabel.setText((currentIndex + 1) + "/" + questions.size());
    }

    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questions.get(currentIndex);

        if (selectedOption.equals(currentQuestion.getCorrectAnswer())) {
            System.out.println("✅ Correcto");
        } else {
            System.out.println("❌ Incorrecto. Respuesta correcta: " + currentQuestion.getCorrectAnswer());
        }
    }

    private void goToNextQuestion() {
        if (currentIndex < questions.size() - 1) {
            currentIndex++;
            showQuestion(questions.get(currentIndex));
        } else {
            System.out.println("🎉 Juego terminado");
            // Aquí podrías mostrar una pantalla final de resultados
        }
    }
}
