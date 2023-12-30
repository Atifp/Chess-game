package chess;

public class Knight extends Piece {

	public Knight(PieceColour colourIn){
		colour = colourIn;
		if (colour == PieceColour.BLACK){
			setSymbol("♞");
		}else{
			setSymbol("♘");
		}
		
	}
	@Override
	public boolean isLegitMove(int iOld,int jOld,int iNew,int jNew){
		int diffI = Math.abs(iNew - iOld);
		int diffJ = Math.abs(jNew - jOld);
		if ((diffI==2 && diffJ==1) || (diffI==2 && -diffI==-1) || (-diffI==-1 && -diffJ==-2)
					|| (diffI==1 && -diffJ==-2) || (-diffI==-1 && diffJ==2) || (-diffI==-2 && -diffJ==-1)){
			if (Board.hasPiece(iNew,jNew) == true) {
				if (Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		return false;
	}
}

