package main.java.com.djm.ticTacToe.exceptions;

import java.util.List;

public class CharacterInputException extends Exception {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
	 * 
	 */

	public CharacterInputException(List<Character> charList){
 
		super("Input must be one of the following : " + charList.toString() );
	}
}