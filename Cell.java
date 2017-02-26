package verson2OO;

public class Cell {
//not private; for package access;
	Seed content;
	int col, row;   //row and col of this seed not used for now;
	
	public Cell(int row, int col){
		this.row = row;
		this.col = col;
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
