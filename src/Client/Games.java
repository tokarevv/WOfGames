package Client;

import java.util.ArrayList;

public class Games {

	private ArrayList<String> games = new ArrayList<String>();
	private static Games instance = null;
	
	private Games(){}
	
	public static Games getInstance(){
		
		if (instance == null){
			instance = new Games();
		}
		return instance;
		
	}
	
	
	public ArrayList<String> getGames() {
		return games;
	}

	public void setGames(ArrayList<String> players) {
		this.games = players;
	}

}
