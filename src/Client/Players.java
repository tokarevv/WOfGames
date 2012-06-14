package Client;

import java.util.ArrayList;

public class Players {

	private ArrayList<String> players = new ArrayList<String>();
	private static Players instance = null;
	
	private Players(){}
	
	public static Players getInstance(){
		
		if (instance == null){
			instance = new Players();
		}
		return instance;
		
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}

}
