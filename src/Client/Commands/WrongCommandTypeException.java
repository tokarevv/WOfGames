package Client.Commands;

public class WrongCommandTypeException extends Exception{
	
	private String description;

	public WrongCommandTypeException(){
		description = "";
	}
	
	public WrongCommandTypeException(String d){
		description = d;
	}
	
	public String toString(){
		return "WrongFileTypeException["+description+"]";
	}
	
}
