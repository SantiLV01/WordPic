package wordpic.models;

import java.util.List;

public class Question {

    private String question;      
    private String image;         
    private String answer;        
    private List<String> options; 

    public Question() {}

 
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    
    public String getText() {
        return question;
    }

   
    public String getImagePath() {
        return image;
    }

    
    public String getCorrectAnswer() {
        return answer;
    }

    
    public boolean isCorrect(String selected) {
        return answer != null && answer.equalsIgnoreCase(selected);
    }
}
