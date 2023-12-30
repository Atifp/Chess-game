package chess;

public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){
		if(input.length() ==2){
			char c1 = input.charAt(0);
			char letter = input.charAt(1);
			int number = Character.getNumericValue(c1);
			if((number >= 1 && number <=8)&&(letter>='a' && letter<='h')){
				return true;
			}
			else{
				return false;
			}
		}
		if(input.equals("END")){
			return true;
		}
		else{
			return false;
		}
		
	}
}
