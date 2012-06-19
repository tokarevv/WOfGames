package Client.Game;

import Client.X0.X0GameAPI;

public class GameFactory {
	
	public aGameAPI getGame(String gameName){
		
		if (gameName.equals("X0")){
			return new X0GameAPI();
		}
		return null;
		
	}
	
}
