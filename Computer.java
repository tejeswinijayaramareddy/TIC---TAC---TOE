/**
@author Chandrayee & Tejeswini
@date Aug 3, 2016
@project Tic-Tac-Toe
 * 
 */

package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
	static int preferredMoves;
	static int[][] pref_plays;
	static int listSize;
	
	/**
	 * 
	 * This function getRandomMove() used to randomly select a cell 
	 * for Computer player.
	 * 
	 * @param currentboard, player
	 * current board is passed to this function that contains row and 
	 * column size and cell content.
	 *  
	 * @return void
	 *  This function returns void.
	 */

	public static void getRandomMove(Board currentboard, entry player) {
		int row = 0, col = 0;
		do {
			int move = (int) (Math.random() * listSize);

			row = move / Board.ROW;
			col = move % Board.COL;

		} while (Board.cells[row][col].cellentry != entry.EMPTY);
		Board.cells[row][col].cellentry = player;
		Board.currentrow = row;
		Board.currentcol = col;

	}
	
	/**
	 * 
	 * This function nextWin() used to  select a potential cell 
	 * for Computer player to win the game.
	 * 
	 * @param currentboard, player
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return foundMatch
	 *  This function returns boolean value true- potential cell found to win
	 *  false- potential call not found to win the game.
	 */
	
	public static boolean nextWin(Board currentboard, int currentRow, int currentCol, entry player){

		Boolean foundMatch, rowMatch = true, colMatch = true, diaMatch = true, revDiaMatch = true;
		
		rowMatch = checkrowMatch( currentboard, currentRow,  currentCol,  player);
		colMatch = checkcolMatch( currentboard, currentRow,  currentCol,  player);
		diaMatch = checkdiaMatch( currentboard, currentRow,  currentCol,  player);
		revDiaMatch = checkrevdiaMatch( currentboard, currentRow,  currentCol,  player);		
		
		foundMatch = rowMatch || colMatch || ((currentRow == currentCol)&& diaMatch) ||((currentRow + currentCol == Board.ROW-1) && revDiaMatch);
		return foundMatch;
		
	}
		
	/**
	 * 
	 * This function checkrowMatch() used to find a possible roe Match
	 * for Computer player to win the game.
	 * 
	 * @param currentboard, player
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return rowMatch
	 *  This function returns boolean.
	 *  true- potential row Match found to win
	 *  false- potential rowMatch not found to win the game.
	 */
	
public static boolean checkrowMatch(Board currentboard, int currentRow, int currentCol, entry player) {
	boolean rowMatch = true;
	int i;
	for(i=0;i<Board.ROW;i++){
		if(i!=currentCol){
			if(currentboard.cells[currentRow][i].cellentry == player){
				rowMatch = rowMatch&&true;
			}
			else{
				rowMatch = rowMatch&&false;
				break;
			}
		}			
	}
	return rowMatch;
}

/**
 * 
 * This function checkcolMatch() used to find a possible column Match
 * for Computer player to win the game.
 * 
 * @param currentboard, player
 * current board, current row, column and player entry are passed to this function.
 *  
 * @return colMatch
 *  This function returns boolean.
 *  true- potential col Match found to win
 *  false- potential colMatch not found to win the game.
 */

public static boolean checkcolMatch(Board currentboard, int currentRow, int currentCol, entry player) {
	boolean colMatch = true;
	int i;
	for(i=0;i<Board.ROW;i++){
		if(i!=currentRow){
			if(currentboard.cells[i][currentCol].cellentry == player){
				colMatch = colMatch&&true;
			}
			else{
				colMatch = colMatch&&false;
				break;
			}
		}
	}
	return colMatch;
}

/**
 * 
 * This function checkdiaMatch() used to find a possible column Match
 * for Computer player to win the game.
 * 
 * @param currentboard, player
 * current board, current row, column and player entry are passed to this function.
 *  
 * @return diaMatch
 *  This function returns boolean.
 *  true- potential diagonal Match found to win
 *  false- potential diaMatch not found to win the game.
 */

public static boolean checkdiaMatch(Board currentboard, int currentRow, int currentCol, entry player) {
	boolean diaMatch = true;
	int i;
	for(i=0;i<Board.ROW;i++){
		if(i!=currentCol&&i!=currentRow){
			if(currentboard.cells[i][i].cellentry == player){
				diaMatch = diaMatch&&true;
			}
			else{
				diaMatch=diaMatch&&false;
				break;
			}
		}
	}
	return diaMatch;
}

/**
 * 
 * This function checkrevdiaMatch() used to find a possible column Match
 * for Computer player to win the game.
 * 
 * @param currentboard, player
 * current board, current row, column and player entry are passed to this function.
 *  
 * @return revdiaMatch
 *  This function returns boolean.
 *  true- potential reverse diagonal Match found to win
 *  false- potential reverse diaMatch not found to win the game.
 */

public static boolean checkrevdiaMatch(Board currentboard, int currentRow, int currentCol, entry player) {
	boolean revdiaMatch = true;
	int i;
	for(i=0;i<Board.ROW;i++){
		if(Board.ROW-1-i!=currentCol&&i!=currentRow){
			if(currentboard.cells[i][Board.ROW-i-1].cellentry == player){
				revdiaMatch=revdiaMatch&&true;
			}
			else{
				revdiaMatch=revdiaMatch&&false;
				break;
			}
		}
	}
	return revdiaMatch;
}
	
/**
 * 
 * This function getWinningMove() used to do a winning move by computer.
 * If no winning move is possible, random cell is chosen to paint.
 * @param currentboard, player
 * current board, current row, column and player entry are passed to this function.
 *  
 * @return integer array where array[0] is the row entry and array[1] is the column entry.
 *  This function returns an integer array.
 *  
 */

	public static int[] getWinningMove(Board currentboard, entry player) {
		
			boolean valid = false; 
			Random rand = new Random();
			int row, col;
			int listIndex;
			
			ArrayList<Integer> listForDiff2Win = new ArrayList<Integer>();
			  for(listIndex=0;listIndex<(Board.ROW * Board.COL);listIndex++){
				  listForDiff2Win.add(listIndex);				  
			  }
			  
			ArrayList<Integer> listRandom = new ArrayList<Integer>();
			listRandom.addAll(listForDiff2Win);
			
			int  index, value;
			
			listIndex=0;
		     do {
		         
		    	 if(listIndex<(Board.ROW * Board.COL)){
		    		 index = rand.nextInt(listForDiff2Win.size());
			         value = listForDiff2Win.get(index);  
			         row = (int)value/Board.ROW;
			         col = (int)value%Board.COL;
			         listForDiff2Win.remove(index); 
			         
			         if (row >= 0 && row < Board.ROW && col >= 0 && col < Board.COL
			               && currentboard.cells[row][col].cellentry == entry.EMPTY && nextWin(currentboard, row, col, player)) {
			        	  int[] etry = new int[2];
			        	  etry[0]=row;
			        	  etry[1]=col;
			        	  valid = true; 
		                return etry;
			         } 
			         listIndex++;
		    	 }		
		    	 if(listIndex == Board.ROW * Board.COL){
		    		 
		    		 index = rand.nextInt(listRandom.size());
			         value = listRandom.get(index);
			         listRandom.remove(index);   
			         row =(int) value/Board.ROW;
			         col = (int) value%Board.COL;
			         if (row >= 0 && row < Board.ROW && col >= 0 && col < Board.COL
			               && currentboard.cells[row][col].cellentry == entry.EMPTY) {
			        	  int[] move = new int[2];
			        	  move[0]=row;
			        	  move[1]=col;
			        	  valid = true; 
			        	  listIndex=0;
		                return move;
		    	 }
		      } 
		     }while (!valid); 
		     listIndex=0;
		      return null;
		   }
	
	/**
	 * 
	 * This function getBlockingMove() used to block user from winning and to select winning cell 
	 * by the computer. Preferred cells as mid cells on each side face and diagonal are preferred and
	 * a center cell of the matrix. Thus giving 5 standard preferred moves. 
	 * 
	 * @param currentboard, player
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return integer array where array[0] is the row entry and array[1] is the column entry.
	 *  This function returns an integer array.
	 *  
	 */
	
	public static int[] getBlockingMove(Board currentboard, entry player) {
		
			  Random rand = new Random();
			  int[] cellentry = new int[2]; 
			  
			  ArrayList<Integer> blockingMoveList = new ArrayList<Integer>();
			  
			  for(int listIndex=0;listIndex<(Board.ROW * Board.COL);listIndex++){
		    	  blockingMoveList.add(listIndex);
		      }
			  
			  int  row, col;
			  boolean blocking = false;  
			  int listdex, value;
			  
		      for(int index=0;index<(Board.ROW * Board.COL);index++){
		    	  
		    	  listdex = rand.nextInt(blockingMoveList.size());
		    	  value = blockingMoveList.get(listdex);
		    	  blockingMoveList.remove(listdex); 
		    	  
			      row = (int)value/Board.ROW;
			      col = (int)value%Board.ROW;
			     
			      if(row >= 0 && row < Board.ROW && col >= 0 && col < Board.ROW
			               && currentboard.cells[row][col].cellentry == entry.EMPTY && nextWin(currentboard, row, col, entry.CROSS)){
		        	
			    	  cellentry[0]=row;
			    	  cellentry[1]=col;
		        	  blocking = true;
		        	  break;
			      }
		      }
		      if(blocking){
		    	  return cellentry;
		      }
		      else{
		    	  
		    	  for (int[] plays : pref_plays) {
		 	         if (currentboard.cells[plays[0]][plays[1]].cellentry == entry.EMPTY) {
		 	            return plays;
		 	         }
		 	      }
		 	      return null;
		      }
		   
		
	}

	/**
	 * 
	 * This function moveDifficulty() used to block user from winning and to select winning cell 
	 * by the computer. Preferred cells as mid cells on each side face and diagonal are preferred and
	 * a center cell of the matrix. Thus giving 5 standard preferred moves. 
	 * 
	 * @param currentboard, player, difficulty
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return void.
	 *  This function returns void.
	 *  
	 */
	
	public static void moveDifficulty(Board currentboard, entry player, int difficulty) {	
		int stdMoves = 5;
		ArrayList<Integer> list = new ArrayList<Integer>();
		listSize = (Board.ROW) * (Board.COL);
		for (int index = 0; index < listSize; index++) {
			list.add(index);
		}
		if (difficulty == 3) {
			int countprefMoves = listSize + stdMoves;
			pref_plays = new int[countprefMoves][2];
			;
			int[] mov0 = { (int) Board.ROW / 2, (int) Board.ROW / 2 };
			int[] mov1 = { 0, 0 };
			int[] mov2 = { 0, (int) Board.ROW - 1 };
			int[] mov3 = { (int) Board.ROW - 1, 0 };
			int[] mov4 = { (int) Board.ROW - 1, (int) Board.ROW - 1 };

			pref_plays[0] = mov0;
			pref_plays[1] = mov1;
			pref_plays[2] = mov2;
			pref_plays[3] = mov3;
			pref_plays[4] = mov4;
			int currentitem = 5;

			for (int i = 0; i < Board.ROW; i++) {
				for (int j = 0; j < Board.COL; j++) {

					int[] move = { i, j };

					if (currentitem != (listSize - 1)) {
						pref_plays[currentitem] = move;
						currentitem = currentitem + 1;

					}
				}
				
			}
		}

		
		if (difficulty == 1) {
			
			getRandomMove(currentboard, player);
		}
		else if(difficulty == 2){
			int[] currentmove = new int[2];
			currentmove = getWinningMove(currentboard, player);
			 currentboard.cells[currentmove[0]][currentmove[1]].cellentry = player;
			 currentboard.currentrow = currentmove[0];
			 currentboard.currentcol = currentmove[1];
		}
		
		else if(difficulty == 3){
			int[] currentmove = new int[2];
			currentmove = getBlockingMove(currentboard, player);
			 currentboard.cells[currentmove[0]][currentmove[1]].cellentry = player;
			 currentboard.currentrow = currentmove[0];
			 currentboard.currentcol = currentmove[1];
			}
		}
	}


