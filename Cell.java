/**
@author Chandrayee & Tejeswini
@date Aug 3, 2016
@project Tic-Tac-Toe
 * 
 */

package tictactoe;

public class Cell {
	int row, col;
	entry  cellentry;

	/**
	 * 
	 * This function Cell() is a constructor.
	 * 
	 * @param row, col
	 * row and col are passed to this function.
	 *  
	 */
	
	public Cell(int row, int col){
		this.row = row;
		this.col = col;
		empty();
	}


	/**
	 * 
	 * This function paint() used to draw 'X' or 'O' entries in a cell.
	 * 
	 * @param 
	 * No parameter is passed to this function.
	 *  
	 * @return void
	 *  This function returns void.
	 */
	
	public void paintcell() {
		switch(cellentry){
		case CROSS: System.out.print(" X ");
		break;
		case NOUGHT: System.out.print(" O ");
		break;
		case EMPTY: System.out.print("   ");
		break;
		}
	}
	
	/**
	 * 
	 * This function empty() used to empty the cell.
	 * 
	 * @param 
	 * No parameter is passed to this function.
	 *  
	 * @return void
	 *  This function returns void.
	 */

	public void empty() {
		cellentry = entry.EMPTY;
	}
}

