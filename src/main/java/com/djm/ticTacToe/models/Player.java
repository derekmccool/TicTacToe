package main.java.com.djm.ticTacToe.models;

public class Player {
    

    private String name;
    private int score = 0;
    private char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void incrementScore(){
        this.score++;
    }

}
