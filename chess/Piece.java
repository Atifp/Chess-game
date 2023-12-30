package chess;

//This class requires your input
public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symb){
		symbol = symb;
	}

	public PieceColour getColour(){
		return colour;
	}

	public abstract boolean isLegitMove(int a,int b,int c,int d);
		
}
