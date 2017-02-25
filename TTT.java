package nonOO;

import java.util.Scanner;

public class TTT {
	//cell states
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int CIRCLE = 2;
	
	// represent the various states of the game
	public static final int PLAYING = 0;
	public static final int DRAW = 3;
	public static final int CROSS_WON = 1;
	public static final int CIRCLE_WON = 2;
	
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
		while(currentState == PLAYING){
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
					System.out.print(" | ");
				}
			}
			System.out.println();
			if(r != ROWS-1){
				System.out.println("----------");
			}
		}
		System.out.println();
	}



	private static void printCell(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case EMPTY: System.out.print(" ");
			break;
		case CIRCLE: System.out.print("O");
			break;
		case CROSS: System.out.print("X");
			break;
		default:
			System.out.println(" ");
			break;
		}
	}


	private static void playerMove(int currentPlayer2) {
		// TODO Auto-generated method stub
		// while loop to check valid Input;
		boolean validInput = false;
		while(!validInput){
			String player = (currentPlayer2 == 1)?"X":"O";
			System.out.println("Player "+player+" Please input your row and column between 0-2: ");
			int row = in.nextInt();
			int col = in.nextInt();
			if(row>2 || row<0 || col>2 || col<0)
				System.out.println("Please input row and column number between 0 to 2");
			else if(board[row][col] != EMPTY)
				System.out.println("Please choose a Empty node");
			else
			{
				currentCol = col;
				currentRow = row;
				validInput = true;
			}
		}
	}


	private static void updateGame(int currentPlayer2, int currentRow2, int currentCol2) {
		// TODO Auto-generated method stub
		board[currentRow2][currentCol2] = currentPlayer2;
		if(won(currentPlayer2, currentRow2, currentCol2))
		currentState = (currentPlayer2 == CROSS)?CROSS:CIRCLE;
		else if(draw())
			currentState = 3;
	}
	
	public static boolean won(int currentPlayer, int currentRow, int currentCol){
		if(board[currentRow][0]==currentPlayer&&board[currentRow][1]==currentPlayer&&board[currentRow][2]==currentPlayer)
			return true;
		if(board[0][currentCol]==currentPlayer&&board[1][currentCol]==currentPlayer&&board[2][currentCol]==currentPlayer)
			return true;
		if(board[0][0]==currentPlayer&&board[1][1]==currentPlayer&&board[2][2]==currentPlayer)
			return true;
		if(board[2][0]==currentPlayer&&board[1][1]==currentPlayer&&board[0][2]==currentPlayer)
			return true;
		return false;
	}


	public static boolean draw(){
		for(int i=0;i<ROWS;i++){
			for(int j=0;j<COLS;j++){
				if(board[i][j]==EMPTY)
					return false;
			}
		}
		return true;
	}
	

	private static void initGame() {
		// TODO Auto-generated method stub
		System.out.println("HELLO");
		for(int row = 0; row < ROWS;row++){
			for(int col = 0;col<COLS;col++){
				board[row][col] = EMPTY;
			}
		}
		currentState  = PLAYING;
		currentPlayer = CROSS;
		System.out.println("Have Fun!");
	}

}
