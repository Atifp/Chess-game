package chess;
import java.io.Console;

public class Game{
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		CheckInput c = new CheckInput();
		Console keyboard = System.console();
		Boolean turn  = true;
		Boolean initial = true;

		while (!gameEnd){ 
			if(turn == true){
				System.out.println("--------WHITE MOVE--------");
				String start =  keyboard.readLine(">Enter Origin:\n"); // ask for origin
				if(start.equals("END")){
					gameEnd = true;
					System.out.println("GAME OVER");
					break;
				}
				Boolean begin = c.checkCoordinateValidity(start); // checks origin is valid
				if(begin == false){ // if not ask again
					System.out.println("INVALID INPUT");
					turn = true;
				}
				else if(begin == true){ // if it is ask for destination
					String	destination = keyboard.readLine(">Enter Destination:\n");
					if(destination.equals("END")){
						gameEnd = true;
						System.out.println("GAME OVER");
						break;
					}
					Boolean	end = c.checkCoordinateValidity(destination);
					if(end == false){
						System.out.println("INVALID INPUT");
						turn = true;
					}
					else if(begin && end == true){ // origin and destination is valid
						int jOld = start.charAt(1) - 'a'; // convert letter to int
						char iOldbefore = start.charAt(0);
						int iOld = Character.getNumericValue(iOldbefore) -1; // match coords
						int jNew = destination.charAt(1) - 'a';
						char iNewbefore = destination.charAt(0);
						int iNew = Character.getNumericValue(iNewbefore) -1;
						Boolean piece_there = Board.hasPiece(iOld,jOld); // checks if initial place has piece

						if(piece_there == false){ // if there is no piece
							System.out.println("NO PIECE FOUND");
							turn = true;
						}
						else if(piece_there == true){
							if(Board.getPiece(iOld,jOld).getColour() != PieceColour.WHITE){
								System.out.println("WHITE MOVE, BlACK CHOSEN");
								turn = true;
							}
							else{
								
								if(Board.getPiece(iOld,jOld).isLegitMove(iOld,jOld,iNew,jNew) == true){ 
									Boolean end3 = Board.movePiece(iOld,jOld,iNew,jNew,(Board.getPiece(iOld,jOld)));
									Board.printBoard();
									if(end3 == false){
										turn = false;
									}else{
										System.out.println("GAME OVER");
										gameEnd = true;
									}

								}else if(Board.getPiece(iOld,jOld).isLegitMove(iOld,jOld,iNew,jNew) == false){
									System.out.println("ILLEGAL MOVE, try again");
									turn = true;
								}
							}
						}
					}
				}
			}
			if(turn == false){
				System.out.println("--------BLACK MOVE--------");
				String start =  keyboard.readLine(">Enter Origin:\n"); // ask for origin
				if(start.equals("END")){
					gameEnd = true;
					System.out.println("GAME OVER");
					break;
				}
				Boolean begin = c.checkCoordinateValidity(start); // checks origin is valid
				if(begin == false){ // if not ask again
					System.out.println("INVALID INPUT");
					turn = false;
				}
				else if(begin == true){ // if it is ask for destination
					String	destination = keyboard.readLine(">Enter Destination:\n");
					if(destination.equals("END")){
						gameEnd = true;
						System.out.println("GAME OVER");
						break;
					}
					Boolean	end = c.checkCoordinateValidity(destination);
					if(end == false){
						System.out.println("INVALID INPUT");
						turn = false;
					}
					else if(begin && end == true){ // origin and destination is valid
						int jOld = start.charAt(1) - 'a'; // convert letter to int
						char iOldbefore = start.charAt(0);
						int iOld = Character.getNumericValue(iOldbefore) -1; // match coords
						int jNew = destination.charAt(1) - 'a';
						char iNewbefore = destination.charAt(0);
						int iNew = Character.getNumericValue(iNewbefore) -1;
						Boolean piece_there = Board.hasPiece(iOld,jOld); // checks if initial place has piece)

						if(piece_there == false){ // if there is no piece
							System.out.println("NO PIECE FOUND");
							turn = false;
						}
						else if(piece_there == true){
							if(Board.getPiece(iOld,jOld).getColour() != PieceColour.BLACK){
								System.out.println("BLACK MOVE, WHITE CHOSEN");
								turn = false;
							}
							else{
								
								if(Board.getPiece(iOld,jOld).isLegitMove(iOld,jOld,iNew,jNew) == true){ 
									Boolean end3 = Board.movePiece(iOld,jOld,iNew,jNew,(Board.getPiece(iOld,jOld)));
									Board.printBoard();
									if(end3 == false){
										turn = true;
									}else{
										System.out.println("GAME OVER");
										gameEnd = true;
									}

								}else if(Board.getPiece(iOld,jOld).isLegitMove(iOld,jOld,iNew,jNew) == false){
									System.out.println("ILLEGAL MOVE, try again");
									turn = false;
								}
							}
						}
					}
				}
			}
			
		}		
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	
	}
}
