/**
@author Chandrayee & Tejeswini
@date Aug 3, 2016
@project Tic-Tac-Toe
 * 
 */

package tictactoe;

public class Board {
	static int ROW = 0;
	static int COL = 0;
	static int currentrow;
	static int currentcol;
	

	static Cell[][] cells;
	
	/**
	 * Board() is an explicit constructor 
	 * 
	 *@param boardSize is an input parameter passing the requested board size.
	 *  
	 */
	
	public Board(int boardSize) {
		ROW = boardSize;
		COL = boardSize;
		cells = new Cell[ROW][COL];
		for (int row = 0; row < ROW; ++row) {
			for (int col = 0; col < COL; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	
	/**
	 * paint() draws the board for requested board size.
	 * This function calls Cell.paint() function to draw 'X' or 'O' entries in a cell.
	 * 
	 * @param String text
	 *  No parameter is passed to this function.
	 *  
	 * @return void
	 *  This function returns void.
	 */

	public void paint() {

		for (int l = 0; l < ROW; l++) {
			System.out.print(" " + (l + 1) + "   ");
		}
		System.out.print("\n");
		String str = new String(new char[ROW+1]).replace("\0", "+ - ");

		for (int row = 0; row < ROW; ++row) {

			if (row < ROW + 1) {

				System.out.println(str);
			}
			
			for (int col = 0; col < COL; col++) {

				if (col < COL + 1) {
					System.out.print("|");
				}
				cells[row][col].paintcell();
			}

			System.out.print("|");
			System.out.println();

		}
		System.out.println(str);
	}

	/**
	 * clear() clears the board by mapping each cell entry to " ".
	 * This function calls Cell.paint() function to draw 'X' or 'O' entries in a cell.
	 * 
	 *  No parameter is passed to this function.
	 *  
	 * @return void
	 *  This function returns void.
	 */
	
	void clear() {
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col].empty();
			}
		}
	}

	/**
	 * checkForDraw() checks if there are no empty cells.
	 * 
	 *  No parameter is passed to this function.
	 *  
	 * @return boolean
	 *  This function returns boolean. 
	 *  Returns true if there is a draw and false if atleast one cell is empty.
	 */
	
	public boolean checkForDraw() {
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				if (cells[row][col].cellentry == entry.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
}
