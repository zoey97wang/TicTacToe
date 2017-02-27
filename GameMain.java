package verson2OO;

import java.util.Scanner;

public class GameMain {
	
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;
	
	private Scanner in = new Scanner(System.in);
	
	public GameMain(){
		board = new Board();
		initGame();
		while(currentState == GameState.PLAYING)
		{
			playerMove(currentPlayer);
			board.paint();
			updateGame(currentPlayer);
			if(currentState == GameState.CIRCLE_WON)
				System.out.println("Player O won!");
			else if(currentState == GameState.CROSS_WON)
				System.out.println("Player X won!");
			else if(currentState == GameState.DRAW)
				System.out.println("It's draw!");
			currentPlayer = (currentPlayer==Seed.CIRCLE)?Seed.CROSS:Seed.CIRCLE;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GameMain();  //new class GameMain; call the constructor : GameMain();
		
	}
	
	public void initGame(){
		board.init();
		currentPlayer = Seed.CROSS;
		currentState = GameState.PLAYING;
	}

	public void playerMove(Seed cPlayer){
		boolean validInput = false;
		while(!validInput){
			if(cPlayer == Seed.CROSS)
				System.out.println("Player X, please input your move(Row[0-2], Column[0-2]): ");
			else
				System.out.println("Player O, please input your move(Row[0-2], Column[0-2]): ");
			
			int row = in.nextInt();
			int col = in.nextInt();
			
			if(row>-1 && row<Board.ROWS && col>-1 && col<Board.ROWS &&
					board.board[row][col].content == Seed.EMPTY){
				board.board[row][col].content = currentPlayer;
				board.currentRow = row;
				board.currentCol = col;
				//board.paint();
				validInput = true;
			}else
				System.out.println("Please input a valid move.");
		}
	}
	
	public void updateGame(Seed currentPlayer){
		if(board.win(currentPlayer))
			currentState = (currentPlayer==Seed.CIRCLE)?GameState.CIRCLE_WON:GameState.CROSS_WON;
		else if(board.draw())
			currentState = GameState.DRAW;
	}
	
}
