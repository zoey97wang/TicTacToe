package verson2OO;

public class Cell {
//not private; for package access;
	Seed content;
	int col, row;   //row and col of this seed not used for now;
	
	public void Cell(int row, int col){
		this.col = col;
		this.row = row;
		clear();
	}
	
	public void clear(){
		content = Seed.EMPTY;
	}
	
	public void paint(){
		switch(content){
			case EMPTY: System.out.println(" "); break;
			case CROSS: System.out.println("X"); break;
			case CIRCLE: System.out.println("O"); break;
		}
	}
}
