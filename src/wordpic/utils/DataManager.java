package wordpic.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import wordpic.models.Question;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String QUESTIONS_FILE = "/questions.json";
    private static final String HISTORY_FILE = "history.txt"; // En carpeta user.home

    public static List<Question> loadQuestions() {
        try (InputStreamReader reader = new InputStreamReader(
                DataManager.class.getResourceAsStream(QUESTIONS_FILE), StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Question>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveHistory(List<String> history) {
        File file = new File(System.getProperty("user.home"), HISTORY_FILE);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, false), StandardCharsets.UTF_8))) {
            for (String record : history) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadHistory() {
        File file = new File(System.getProperty("user.home"), HISTORY_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            return reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Nuevo método para agregar una partida sin perder historial previo
    public static void addHistoryRecord(String record) {
        List<String> history = loadHistory();
        history.add(record);
        saveHistory(history);
    }
}
