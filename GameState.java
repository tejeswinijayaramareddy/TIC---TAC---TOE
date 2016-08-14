/**
@author Chandrayee & Tejeswini
@date Aug 3, 2016
@project Tic-Tac-Toe
 * 
 */

package tictactoe;

public class GameState {
	
	/**
	 * 
	 * This function hasWon() function used to check if the player has won the game.
	 * 
	 * @param currentboard, player
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return boolean
	 *  This function returns boolean. Returns true if the player has won the game.
	 */
	
	public static boolean hasWon(Board currentboard, int currentRow, int currentCol, entry player) {
		Boolean status = false, rowMatch = false, colMatch = false, diaMatch = false, revDiaMatch = false;

		switch (currentboard.ROW) {
		case 1:
			rowMatch = true;
			colMatch = true;
			break;
		case 2:
			if ((currentboard.cells[currentRow][0].cellentry == player)
					&& (currentboard.cells[currentRow][1].cellentry == player)) {
				rowMatch = true;
			}
			if ((currentboard.cells[0][currentCol].cellentry == player)
					&& (currentboard.cells[1][currentCol].cellentry == player)) {
				colMatch = true;
			}
			if ((currentboard.cells[0][0].cellentry == player) && (currentboard.cells[1][1].cellentry == player)) {
				diaMatch = true;
			}
			if ((currentboard.cells[0][1].cellentry == player) && (currentboard.cells[1][1].cellentry == player)) {
				revDiaMatch = true;
			}
			break;
		case 3:
			if ((currentboard.cells[currentRow][0].cellentry == player)
					&& (currentboard.cells[currentRow][1].cellentry == player)
					&& (currentboard.cells[currentRow][2].cellentry == player)) {
				rowMatch = true;
			}
			if ((currentboard.cells[0][currentCol].cellentry == player)
					&& (currentboard.cells[1][currentCol].cellentry == player)
					&& (currentboard.cells[2][currentCol].cellentry == player)) {
				colMatch = true;
			}
			if ((currentboard.cells[0][0].cellentry == player) && (currentboard.cells[1][1].cellentry == player)
					&& (currentboard.cells[2][2].cellentry == player)) {
				diaMatch = true;
			}
			if ((currentboard.cells[0][2].cellentry == player) && (currentboard.cells[1][1].cellentry == player)
					&& (currentboard.cells[2][0].cellentry == player)) {
				revDiaMatch = true;
			}

			break;
		case 4:
			if ((currentboard.cells[currentRow][0].cellentry == player)
					&& (currentboard.cells[currentRow][1].cellentry == player)
					&& (currentboard.cells[currentRow][2].cellentry == player)
					&& (currentboard.cells[currentRow][3].cellentry == player)) {
				rowMatch = true;
			}
			if ((currentboard.cells[0][currentCol].cellentry == player)
					&& (currentboard.cells[1][currentCol].cellentry == player)
					&& (currentboard.cells[2][currentCol].cellentry == player)
					&& (currentboard.cells[3][currentCol].cellentry == player)) {
				colMatch = true;
			}
			if ((currentboard.cells[0][0].cellentry == player) && (currentboard.cells[1][1].cellentry == player)
					&& (currentboard.cells[2][2].cellentry == player)
					&& (currentboard.cells[3][3].cellentry == player)) {
				diaMatch = true;
			}
			if ((currentboard.cells[0][3].cellentry == player) && (currentboard.cells[1][2].cellentry == player)
					&& (currentboard.cells[2][1].cellentry == player)
					&& (currentboard.cells[3][0].cellentry == player)) {
				revDiaMatch = true;
			}

			break;
		case 5:
			if ((currentboard.cells[currentRow][0].cellentry == player)
					&& (currentboard.cells[currentRow][1].cellentry == player)
					&& (currentboard.cells[currentRow][2].cellentry == player)
					&& (currentboard.cells[currentRow][3].cellentry == player)
					&& (currentboard.cells[currentRow][4].cellentry == player)) {
				rowMatch = true;
			}
			if ((currentboard.cells[0][currentCol].cellentry == player)
					&& (currentboard.cells[1][currentCol].cellentry == player)
					&& (currentboard.cells[2][currentCol].cellentry == player)
					&& (currentboard.cells[3][currentCol].cellentry == player)
					&& (currentboard.cells[4][currentCol].cellentry == player)) {
				colMatch = true;
			}
			if ((currentboard.cells[0][0].cellentry == player) && (currentboard.cells[1][1].cellentry == player)
					&& (currentboard.cells[2][2].cellentry == player)
					&& (currentboard.cells[3][3].cellentry == player)
					&& (currentboard.cells[4][4].cellentry == player)) {
				diaMatch = true;
			}
			if ((currentboard.cells[0][4].cellentry == player) && (currentboard.cells[1][3].cellentry == player)
					&& (currentboard.cells[2][2].cellentry == player)
					&& (currentboard.cells[3][1].cellentry == player)
					&& (currentboard.cells[4][0].cellentry == player)) {
				revDiaMatch = true;
			}

			break;
		}

		if (rowMatch || colMatch || diaMatch || revDiaMatch) {
			status = true;
		}
		return status;
	}

	/**
	 * 
	 * This function checkDraw() function 
	 * 
	 * @param currentboard
	 * current board is passed to this function.
	 *  
	 * @return boolean
	 *  This function returns true if it is draw.
	 */

	public static boolean checkDraw(Board currentboard) {
		for (int row = 0; row < currentboard.ROW; ++row) {
			for (int col = 0; col < currentboard.COL; ++col) {
				if (currentboard.cells[row][col].cellentry == entry.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
}
