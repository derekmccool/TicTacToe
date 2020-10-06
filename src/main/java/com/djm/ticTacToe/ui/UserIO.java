package main.java.com.djm.ticTacToe.ui;

public interface UserIO {

    public void print(String message);

    public String readString(String prompt);

    public int readInt(String prompt);

    public char readChar(String prompt);
}
