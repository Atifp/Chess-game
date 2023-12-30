package chess;

public class Rook extends Piece{

	public Rook(PieceColour p){
		colour = p;
		if (colour == PieceColour.BLACK){
			setSymbol("♜");
		}else{
			setSymbol("♖");
		}
	}

@Override
public boolean isLegitMove(int iOld, int jOld, int iNew, int jNew) {
		if (((iOld == iNew) && (jNew != jOld)) || ((jOld == jNew) && (iNew != iOld))) { 

			if ((iOld == iNew) && (jNew > jOld)) { // move right
				for (int j=jOld+1; j<jNew; j++) {
					if (Board.hasPiece(iOld,j) == true) {
						return false;
					}
				}
				if (Board.hasPiece(iNew,jNew)) {
					if (Board.getPiece(iNew,jNew).getColour() == Board.getPiece(iOld,jOld).getColour()) {
						return false;
					}
				}
				return true;
			}
			if ((iOld == iNew) && (jOld > jNew)) { //move left
				for (int j=jOld-1; j>jNew; j--) {
					if (Board.hasPiece(iOld,j) == true) {
						return false;
					}
				}
				if (Board.hasPiece(iNew,jNew)) {
					if (Board.getPiece(iNew,jNew).getColour() == Board.getPiece(iOld,jOld).getColour()) {
						return false;
					}
				}
				return true;
			}
			if ((jOld == jNew) && (iNew > iOld)) { // move down
				for (int i=iOld+1; i<iNew; i++) {
					if (Board.hasPiece(i,jOld) == true) {
						return false;
					}
				}
				if (Board.hasPiece(iNew,jNew)) {
					if (Board.getPiece(iNew,jNew).getColour() == Board.getPiece(iOld,jOld).getColour()) {
						return false;
					}
				}
				return true;
			}
			if ((jOld == jNew) && (iNew < iOld)) { //move up
				for (int i=iOld-1; i>iNew; i--) { // for loop checking pieces ahead
					if (Board.hasPiece(i,jOld) == true) { // if there is a piece, dont move (cant jump over pieces)
						return false;
					}
				}
				if (Board.hasPiece(iNew,jNew)) { // if there is a piece in the place that u are moving
					if (Board.getPiece(iNew,jNew).getColour() == Board.getPiece(iOld,jOld).getColour()) {
						return false; // and the piece is the same colour, dont move
					}
				}
				return true;
			}
		}
	return false;
	}
}



