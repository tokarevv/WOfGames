package Client.Commands;

import java.util.HashMap;

import Client.ResponseHandler;

public class CommandFactory {
	
	private static HashMap<String, aCommand> commandsList = null;

	
	public static aCommand getCommand(ResponseHandler rh) throws WrongCommandTypeException{

		if(commandsList == null){
			initCommandsList(rh);
		}
		
		aCommand res = commandsList.get(rh.getCommand());
		
		if (res == null){
			throw new WrongCommandTypeException("Invalid command - \""+rh.getCommand()+"\"");
		}
		
		return res;
	
	}
	
	private static void initCommandsList(ResponseHandler rh){
		commandsList = new HashMap<String, aCommand>();
//		iDSList.put("json", DS_JSON.getInstance());
		commandsList.put("refusegame", new RefuseGameCommand(rh));
		commandsList.put("badname",    new BadNameCommand(rh));
		commandsList.put("playerlist", new PlayerListCommand(rh));
		commandsList.put("refusegame", new RefuseGameCommand(rh));
	}

}
