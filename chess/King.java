package chess;

public class King extends Piece{

	public King(PieceColour colourIn){
		colour = colourIn;
		if (colour == PieceColour.BLACK){
			setSymbol("♚");
		}else{
			setSymbol("♔");
		}
		
	}
	@Override
	public boolean isLegitMove(int iOld,int jOld,int iNew,int jNew){ 
		int diffI = Math.abs(iNew - iOld);
		int diffJ = Math.abs(jNew - jOld); 
		

		if((iNew == iOld) && (diffJ == 1) || (jNew == jOld) && (diffI == 1) || diffI == diffJ ){

			if(iOld>iNew && jOld==jNew){  // move up
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;  					
			}
			if(iNew>iOld && jOld==jNew){ //move down
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iOld == iNew && jOld > jNew){ // move left
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iNew == iOld && jOld < jNew){ // move right
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iNew > iOld && jOld>jNew){ //down left
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iNew > iOld && jOld<jNew){ // down right
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iNew < iOld && jOld > jNew){ //up left
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if(iOld>iNew && jNew>jOld){ //up right  2617
				if(Board.hasPiece(iNew,jNew) == true){
					if(Board.getPiece(iNew,jNew).getColour() != Board.getPiece(iOld,jOld).getColour()){
						return true; 
					}else{
						return false;
					}
					
				}else{
					return true;
				}
			}
		
		}
		return false;	
	
	}
}