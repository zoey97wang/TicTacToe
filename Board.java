package verson2OO;

public class Board {

	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	Cell[][] board;
	int currentRow, currentCol;
	
	public Board(){
		board = new Cell[ROWS][COLS];
		// allocate element to array:
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				board[row][col] = new Cell(row, col);
			}
		}
	}
	
	public void init(){
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				board[row][col].clear();;
			}
		}
	}
	
	public boolean draw(){
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				if(board[row][col].content == Seed.EMPTY)
					return false;
			}
		}
		return true;
	}
	
	public boolean win(Seed currentPlayer){
		if(board[currentRow][0].content==currentPlayer&&
				board[currentRow][1].content==currentPlayer&&
				board[currentRow][2].content==currentPlayer)
			return true;
		if(board[0][currentCol].content==currentPlayer&&
				board[1][currentCol].content==currentPlayer&&
				board[2][currentCol].content==currentPlayer)
			return true;
		if(board[0][0].content==currentPlayer&&
				board[1][1].content==currentPlayer&&
				board[2][2].content==currentPlayer)
			return true;
		if(board[2][0].content==currentPlayer&&
				board[1][1].content==currentPlayer&&
				board[0][2].content==currentPlayer)
			return true;
		return false;
	}
	
	public void paint(){
		for(int r = 0;r<ROWS;r++){
			for(int c = 0;c<COLS;c++){
				board[r][c].paint();
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
	
}
