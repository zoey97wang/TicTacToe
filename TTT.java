package nonOO;

import java.util.Scanner;

public class TTT {
	//cell states
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int CIRCLE = 2;
	
	// represent the various states of the game
	public static final int PLAYING = 0;
	public static final int DRAW = 1;
	public static final int CROSS_WON = 2;
	public static final int CIRCLE_WON = 3;
	
	//game board
	public static final int ROWS = 3, COLS = 3;
	public static int[][] board = new int[ROWS][COLS];
	public static int currentState;//play;draw;win;cwin;
	public static int currentPlayer;
	public static int currentRow, currentCol;//current seed's row and column
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize the game-board and current status
		initGame();
		while(currentState == PLAYING);{
			playerMove(currentPlayer);
			updateGame(currentPlayer,currentRow,currentCol);
			printBoard();
			//check if game over;
			if(currentState == CROSS_WON){
				System.out.println("'X' won! Bye!");
			} else if(currentState == CIRCLE_WON){
				System.out.println("'O' won! Bye!");
			} else if(currentState == DRAW){
				System.out.println("It's a Draw! Bye!");
			}
			//if not over;switch player;
			currentPlayer = (currentPlayer == CROSS)?CIRCLE:CROSS;
		}
	}



	private static void printBoard() {
		// TODO Auto-generated method stub
		for(int r = 0;r<ROWS;r++){
			for(int c = 0;c<COLS;c++){
				printCell(board[r][c]);
				if(c != COLS-1){
					System.out.print("|");
				}
			}
			System.out.println();
			if(r != ROWS-1){
				System.out.println("-----------------");
			}
		}
		System.out.println();
	}



	private static void printCell(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case EMPTY: System.out.println(" ");
			break;
		case CIRCLE: System.out.println("O");
			break;
		case CROSS: System.out.println("X");
			break;
		default:
			System.out.println(" ");
			break;
		}
	}



	private static void playerMove(int currentPlayer2) {
		// TODO Auto-generated method stub
		
	}



	private static void updateGame(int currentPlayer2, int currentRow2, int currentCol2) {
		// TODO Auto-generated method stub
		
	}



	private static void initGame() {
		// TODO Auto-generated method stub
		for(int row = 0; row < ROWS;row++){
			for(int col = 0;col<COLS;col++){
				board[row][col] = EMPTY;
			}
		}
		currentState  = PLAYING;
		currentPlayer = CROSS;
	}

}
