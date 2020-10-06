package main.java.com.djm.ticTacToe.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.com.djm.ticTacToe.models.Player;
import main.java.com.djm.ticTacToe.ui.GameView;

public class GameRunner {


    private final char SYMBOL1 = 'X';
    private final char SYMBOL2 = 'O';

    private GameView gv;
    private Player player1;
    private Player player2;
    private Player winner;
    private char[][] gameBoard = new char[3][3];
    private boolean endMatch = false;
    private boolean endGame = false;
    private int playerTurn = 1;
    private int round;


    public GameRunner(GameView gv){
        this.gv = gv;
    }

    public void playGame(){
        round = 1;
        gv.welcomeBanner();
        setPlayers();
        while(!endGame){
            setGameBoard();
            while(!endMatch){
                printGameBoardToConsole();
                getPlayerChoice();
                checkForWinner();
                round++;
            }
            printGameBoardToConsole();
            printWinner();
            setEndGame();
        }
    }

    public void setPlayers(){
        String name1 = gv.getPlayerNameFromConsole("Please Enter A Name For Player 1: ");
        player1 = new Player(name1, SYMBOL1);
        String name2 = gv.getPlayerNameFromConsole("Please Enter A Name For Player 2: ");
        player2 = new Player(name2, SYMBOL2);
    }

    public void printGameBoardToConsole(){
        gv.displayGameBoard(gameBoard, round);
    }

    public void printWinner(){
        gv.displayWinner(winner.getName(), winner.getSymbol(), winner.getScore());
    }

    public void getPlayerChoice(){

        switch(playerTurn){
            case 1:
                checkValidChoice(player1);
                playerTurn = 2;
                break;

            case 2:
                checkValidChoice(player2);
                playerTurn = 1;
                break;
        }
  
    }

    public void setPlayerChoice(int[] choice, char symbol){
        gameBoard[choice[0]][choice[1]] = symbol;
     }

    private void checkValidChoice(Player player){
        int[] choice = new int[2];
        while(true){
            choice = gv.getPlayerChoice(player.getName(), player.getSymbol());
            if(Character.compare(gameBoard[choice[0]][choice[1]], ' ') == 0){
                setPlayerChoice(choice, player.getSymbol());
                break;
            }else{
                System.out.println("Spot already taken.");
            }
        }
    }

     public void checkForWinner(){
         for(int i = 0; i < gameBoard.length; i++){
             if(gameBoard[i][0] != ' ' && gameBoard[i][1] != ' ' && gameBoard[i][2] != ' '){
                checkWinHorizontal(i);
             }
          
         }
         for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[0][i] != ' ' && gameBoard[1][i] != ' ' && gameBoard[2][i] != ' '){
                checkVerticalWinner(i);
            }
        }

        if(gameBoard[0][0] != ' ' && gameBoard[1][1] != ' ' && gameBoard[2][2] != ' '){
            checkTopLeftDiagonalWinner();
        }

        if(gameBoard[0][2] != ' ' && gameBoard[1][1] != ' ' && gameBoard[2][0] != ' '){
            checkBottomLeftDiagonalWinner();
        }
          
     }

     public void checkWinHorizontal(int row){

        List<Character> rowList = new ArrayList<>();
            rowList.add(gameBoard[row][0]);
            rowList.add(gameBoard[row][1]);
            rowList.add(gameBoard[row][2]);
            endMatch = rowList.stream().distinct().limit(2).count() <= 1;
            if(endMatch){
                setWinner(gameBoard[row][0]);
            }
     }

     public void checkVerticalWinner(int column){
        List<Character> colList = new ArrayList<>();
            colList.add(gameBoard[0][column]);
            colList.add(gameBoard[1][column]);
            colList.add(gameBoard[2][column]);
            endMatch = colList.stream().distinct().limit(2).count() <= 1;
        if(endMatch){
            setWinner(gameBoard[0][column]);
        }
     }

     public void checkTopLeftDiagonalWinner(){
        List<Character> diagList = new ArrayList<>();
        diagList.add(gameBoard[0][0]);
        diagList.add(gameBoard[1][1]);
        diagList.add(gameBoard[2][2]);
        endMatch = diagList.stream().distinct().limit(2).count() <= 1;
        
        if(endMatch){
            setWinner(gameBoard[0][0]);
        }
     }
     
     public void checkBottomLeftDiagonalWinner(){
        List<Character> diagList = new ArrayList<>();
        diagList.add(gameBoard[0][2]);
        diagList.add(gameBoard[1][1]);
        diagList.add(gameBoard[2][0]);
        endMatch = diagList.stream().distinct().limit(2).count() <= 1;
        if(endMatch){
            setWinner(gameBoard[0][2]);
        }
     }

     public void setWinner(char symbol){
        if(Character.compare(symbol, SYMBOL1) == 0){
            winner = player1;
        }else{
            winner = player2;
        }
        winner.incrementScore();
     }

     //sets the gameboard to empty values
     public void setGameBoard(){
        for(int i = 0; i < gameBoard.length; i++){
            gameBoard[i][0] = ' ';
            gameBoard[i][1] = ' ';
            gameBoard[i][2] = ' ';
        }
     }

     //checks to see if players want to play another game and
    //resets match to false if players choose to play again
    public void setEndGame(){
        endGame = gv.playAgain();
        if(!endGame){
            endMatch = false;
        }
     }

}
