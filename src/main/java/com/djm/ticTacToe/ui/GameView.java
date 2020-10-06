package main.java.com.djm.ticTacToe.ui;

public class GameView {
    private UserIO userIO;

    public GameView(UserIO userIO){
        this.userIO = userIO;
    }

    public void welcomeBanner(){
        userIO.print("****************************************");
        userIO.print("**************Welcome To****************");
        userIO.print("*************Tic Tac Toe****************");
        userIO.print("****************************************");
    }

    public String getPlayerNameFromConsole(String prompt){
        return userIO.readString(prompt);
    }

    public void displayGameBoard(char[][] gameBoard, int round){
        userIO.print("________________________________________");
        userIO.print("              GameBoard                 ");
        userIO.print("              Round " + round);
        userIO.print("________________________________________");
        System.out.println("              A   B   C");
        for(int i = 0; i < gameBoard.length; i++){
            System.out.print("          " + i + " ");
            System.out.print("[ " + gameBoard[i][0] + " ]");
            System.out.print("[ " + gameBoard[i][1] + " ]");
            System.out.print("[ " + gameBoard[i][2] + " ]\n");

        }
        userIO.print("________________________________________");
    } 

    public int[] getPlayerChoice(String name, char symbol){
        int[] rowColumn = new int[2];
        userIO.print(name + " turn (" + symbol + ")");
        rowColumn[0] = userIO.readInt("Pick A Row: ", 0, 2);
        switch(userIO.readChar("Pick A Column: ")){

            case 'a':
                rowColumn[1] = 0;
                break;
            case 'b':
                rowColumn[1] = 1;
                break;  
            case 'c':
                rowColumn[1] = 2;
                break;  
        }
        return rowColumn;

    }

    public void displayWinner(String name, char symbol, int score){
        userIO.print(name + " (" + symbol + ") wins! games won: " + score);
    }

    public boolean playAgain(){
      
        switch(userIO.readChar("Play Again? Y/N : ")){

            case 'y':
                return false;
            case 'b':
                return true;
            default:
                return true;
        }
    }
}
