package chess;

public class Bishop extends Piece{

	public Bishop(PieceColour colourIn){
		colour = colourIn;
		if (colour == PieceColour.BLACK){
			setSymbol("♝");
		}else{
			setSymbol("♗");
		}
	}
	@Override
	public boolean isLegitMove(int iOld,int jOld,int iNew,int jNew){
		int diffI = Math.abs(iNew - iOld);
		int diffJ = Math.abs(jNew - jOld);

		if(diffI == diffJ ){ // checks for diagonal movement 

			if((iNew > iOld) && (jNew >jOld)){ //down right
				int j= jOld + 1;
				for(int i = iOld+1; i < iNew; i++){
					if(Board.hasPiece(i,j) == true){
						return false;
					}
					j+=1;
				}
				if(Board.hasPiece(iNew,jNew) == true){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // captures the piece
					}else{
						return false;
					}
				}
				return true;
			}
			if(iNew > iOld && jOld > jNew){ //moving down left 
				//int j = jNew+1;
				for(int i= iOld+1,j = jOld -1; i<iNew;i++,j--){
					if(Board.hasPiece(i,j)==true){
						return false;
					}
					//j+=1;
				}
				if(Board.hasPiece(iNew,jNew) == true){
					if(Board.getPiece(iNew,jNew).getColour()!=Board.getPiece(iOld,jOld).getColour()){
						return true; // dont move
					}else{
						return false;
					}
					
				}
				return true;
				
			}
			if(iNew < iOld && jNew > jOld){ // diagonally up right 
				int j = jOld +1;
				for(int i = iOld -1; i > iNew; i--){
					if(Board.hasPiece(i,j) == true){
						return false;
					}
					j+= 1;
				}
				if(Board.hasPiece(iNew,jNew) == true){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}
			if((iOld > iNew) &&  (jOld> jNew)){ //diagonally up left 
				int i= iNew+1;
				for(int j = jNew + 1; j< jOld ; j++){
					if(Board.hasPiece(i,j) == true ){
						return false;
					}
					i = i+1;
				}
				if(Board.hasPiece(iNew,jNew)){
					if(Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour()){
						return true; // dont move
					}else{
						return false;
					}
				}
				return true;
			}

		}
		return false;
	}
}




















