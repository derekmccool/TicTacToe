package main.java.com.djm.ticTacToe.ui;

import java.util.List;

public interface UserIO {

    void print(String message);

    String readString(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    char readChar(String prompt, List<Character> charList);

}
