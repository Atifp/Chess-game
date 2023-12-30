package chess;

public class Pawn extends Piece{	
	
	public Pawn(PieceColour colourIn){
		colour = colourIn;
		if (colour == PieceColour.BLACK){
			setSymbol("♟︎");
		}else{
			setSymbol("♙");
		}
	} 
	@Override
	public boolean isLegitMove(int iOld,int jOld,int iNew,int jNew){
		int diffI = iNew - iOld;
		int diffJ = jNew - jOld;

		if(iOld == 6 && diffJ == 0 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.WHITE))){ // Initial white move is 2
			if(iOld-iNew ==2 && diffJ == 0){
				if(Board.hasPiece(iOld-1,jNew) == true){ // checks the place ahead
					return false;
				}
				if(Board.hasPiece(iNew,jNew) == true){ // if in new place theres something
					return false;
				}
				return true;
			}
		}
		if(iOld ==1 && diffJ ==0 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.BLACK))){ //black piece
			if(iNew-iOld==2 && diffJ == 0){ // first move, move forward by2
				if(Board.hasPiece(iOld+1,jNew) == true){ // checks the place ahead
					return false;
				}
				if(Board.hasPiece(iNew,jNew) == true){ // if in new place theres something
					return false;
				}
				return true;
			}
		}
		if((diffI==1 && diffJ ==0) || (iOld-iNew==1 && diffJ==0) || ( diffI==1 && diffJ ==1) 
			|| (diffI ==1 && jOld-jNew ==1) || (iOld-iNew==1 && diffJ ==1) || (iOld-iNew ==1 && jOld-jNew ==1)){

			if(iNew-iOld==1 && diffJ == 0 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.BLACK))){ // black piece up
				if(Board.hasPiece(iNew,jNew) == true){
					return false;
				}
				return true;
			}
			if(iOld-iNew==1  && jNew == jOld && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.WHITE))){ // white piece up
				if(Board.hasPiece(iNew,jNew) == true){
					return false;
				}
				return true;
			}
			if(iOld-iNew==1 && diffJ ==1 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.WHITE))){ // white up right
				if(Board.hasPiece(iNew,jNew)== true){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
			if(iOld-iNew==1 && jOld-jNew ==1 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.WHITE))){ // white up left
				if(Board.hasPiece(iNew,jNew)== true){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
			if(diffI==1 && diffJ ==1 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.BLACK))){ // black up right
				if(Board.hasPiece(iNew,jNew)== true){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
			if(iNew-iOld==1 && jOld-jNew==1 && (Board.getPiece(iOld,jOld).getColour().equals(PieceColour.BLACK))){ // black up right 3544
				if(Board.hasPiece(iNew,jNew)== true){
					if(Board.getPiece(iOld,jOld).getColour() == Board.getPiece(iNew,jNew).getColour()){
						return false;
					}else{
						return true;
					}
				}
			}

		}
		return false;
	}
}
