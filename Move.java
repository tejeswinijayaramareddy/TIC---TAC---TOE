/**
@author Chandrayee & Tejeswini
@date Aug 3, 2016
@project Tic-Tac-Toe
 * 
 */

package tictactoe;

import java.util.Scanner;

public class Move {
	static boolean validInput = false;
	
	/**
	 * 
	 * This function validateInput() validates user input 
	 * 
	 * @param row, col
	 * user given row and col are passed to check their validity.
	 *  
	 * @return boolean
	 *  This function returns true if valid.
	 */
	
	public static boolean validateInput(int row, int col) {
		if ((row < 0) || (row >= Board.ROW)) {
			System.out.println("Invalid Row Number");
			validInput = false;
		} else if ((col < 0) || (col >= Board.COL)) {
			System.out.println("Invalid column number");
			validInput = false;
		} else if (Board.cells[row][col].cellentry != entry.EMPTY) {
			System.out.println("Choosen cell is not empty");
			validInput = false;
		} else {
			validInput = true;
		}
		return validInput;
	}

	/**
	 * 
	 * This function makeMove() asks user to input their move and calls 
	 * validateInput() to check for input validity. 
	 * 
	 * @param player
	 * user input  "X"
	 *  
	 * @return void
	 *  This function returns void.
	 */
	
	public static void makeMove(entry player) {
		int[] move = new int[2];
		int row, col;
		Scanner in = new Scanner(System.in);
		boolean valid;
		do {

			System.out.println("What is your move? Please type a row number "
					+ "from 1 to 3 and a column number from 1 to 3");

			row = in.nextInt() - 1;
			col = in.nextInt() - 1;

			System.out.println("My move is row" + row + "column" + col + "");

			valid = validateInput(row, col);
		} while (!valid);
		Board.cells[row][col].cellentry = player;
		Board.currentrow = row;
		Board.currentcol = col;

	}

}
