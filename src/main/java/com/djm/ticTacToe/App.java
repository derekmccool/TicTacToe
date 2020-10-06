package main.java.com.djm.ticTacToe;

import main.java.com.djm.ticTacToe.controllers.GameRunner;
import main.java.com.djm.ticTacToe.ui.GameView;
import main.java.com.djm.ticTacToe.ui.UserIO;
import main.java.com.djm.ticTacToe.ui.UserIOImpl;

public class App {
    public static void main(String[] args) throws Exception {
        UserIO userIO = new UserIOImpl();
        GameView gv = new GameView(userIO);
        GameRunner gr = new GameRunner(gv);

        gr.playGame();
    }
}
