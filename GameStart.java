/**
 * This is the mail file in Project Tic-Tac-Toe example. 
 *  
 *  @Authors - Chandrayee & Tejeswini
 */
package tictactoe;
import java.util.Scanner;

public class GameStart {
	
	private static Boolean isFirst = true; 
	private static int Playanother = 0;
	private static State currentState;
	private static entry currentPlayer; 
	private static entry cellContent; 
	//private static 
	
	/**
	 * 
	 * This function main() function 
	 * 
	 * @param currentboard, player
	 * current board, current row, column and player entry are passed to this function.
	 *  
	 * @return void
	 *  This function returns void.
	 */
	
	public static void main(String[] args) {
		try{
		 System.out.println("Welcome to Tic-Tac-Toe");
		 System.out.println( "\n"); 
		 currentPlayer = entry.CROSS;
		 
		 do {
		 System.out.print("Enter number to choose board Size from 1 to 5 : \n");
		 Scanner in = new Scanner(System.in);
		 int ts_boardSize = in.nextInt();
		
		 boolean validDiffLevel = false;   
		 int ts_difficulty;
		 System.out.println("Enter the Difficulty level: 1 - Easy, 2 - Medium, 3 - Hard");
	     
		 
		 do {		 
		 ts_difficulty = in.nextInt();
		 if((ts_difficulty < 4)&&(ts_difficulty > 0)){
			 validDiffLevel = true;
		 } 
		 else {
			 System.out.println("Entered Invalid Difficulty level");
			 System.out.println("Enter Difficulty Level: 1 - Easy, 2 - Medium, 3 - Hard");
		     
		 }
		 }while(!validDiffLevel);
		 currentState = State.PLAYING; 
		 Board board = new Board(ts_boardSize);
		 board.clear();
		 isFirst = false;
		 cellContent = entry.EMPTY;
		 board.paint();  
		 do {
		 if(currentPlayer == entry.CROSS){
		 Move.makeMove(currentPlayer);
		 
		 
		 } else if(currentPlayer == entry.NOUGHT)
		 {
			 Computer.moveDifficulty(board, currentPlayer, ts_difficulty);
					 
			 }
		 
		 board.paint();
		 if(GameState.hasWon(board,board.currentrow ,board.currentcol,currentPlayer)){
		 
			 if(currentPlayer == entry.CROSS){
				 System.out.println("X won the game");
				 currentState = State.YOU_WON;
				 
			 } else
			 {
				 System.out.println("O won the game");
				 currentState = State.COMPUTER_WON;
			 }
		 
		 } else if (GameState.checkDraw(board)) {
			 	System.out.println("It is a draw!");
			 	currentState = State.DRAW;
		 }
		 
		 // swap player
		 currentPlayer = (currentPlayer == entry.CROSS)? entry.NOUGHT : entry.CROSS;
		
		 
		 } while(currentState == State.PLAYING);

		 System.out.print("Do you want to play another game: Y for Yes , N for NO");
		 char Playanother = in.next().charAt(0);
		if((Playanother != 'y') && (Playanother != 'Y')){
			System.out.println("Bye");
			System.exit(0);
		}
		 }
		 while(true);
		}
	      catch(Exception exception)
	      {
	    	 // exception.printStackTrace();
	        System.out.println("Something Went Wrong, Start Again");
	      }
	}
}
