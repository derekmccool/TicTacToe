package main.java.com.djm.ticTacToe.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.com.djm.ticTacToe.exceptions.InputOutOfRangeException;

public class UserIOImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    //prints all caps
    public void print(String message) {
        System.out.println(message.toUpperCase());
    }

    @Override
    public String readString(String prompt) {
		String userInput;
		while (true) {
			try {
				System.out.print(prompt);
				userInput = sc.nextLine();
				return userInput;
				
			} catch (InputMismatchException e) {
				System.out.println("Please insert a proper value");
			}
			
		}
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
			try {
				System.out.print(prompt);
				return sc.nextInt();
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Please insert an integer value");
			}
			
		}
    }

    @Override
    public int readInt(String prompt, int min, int max) {
		int userInput;
		while (true) {
			try {
				System.out.print(prompt);
				userInput = sc.nextInt();
				if(userInput >= min &&  userInput <= max) {
					return userInput;
				}else {
					throw new InputOutOfRangeException(min, max);
				}
				
			} catch (InputOutOfRangeException e) {
				sc.nextLine();
				System.out.println("Please insert an integer value");
			}
			
		}
    }
    

    @Override
    public char readChar(String prompt) {
		char userInput;
		while (true) {
			try {
				System.out.print(prompt);
				userInput = sc.next().toLowerCase().charAt(0);
				return userInput;
				
			} catch (InputMismatchException e) {
				System.out.println("Please insert a proper value");
			}
			
		}
    }

    
}
