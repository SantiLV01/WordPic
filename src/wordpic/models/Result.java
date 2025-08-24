package wordpic.models;

public class Result {
    private String playerName;
    private int score;

    public Result(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() { return playerName; }
    public int getScore() { return score; }
}
