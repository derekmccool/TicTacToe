package main.java.com.djm.ticTacToe.exceptions;

public class InputOutOfRangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5971987058051092242L;

	public InputOutOfRangeException(int min, int max){
		super("Input must be betwee " + min + "-" + max);
	}
}