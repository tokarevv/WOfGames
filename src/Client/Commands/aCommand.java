package Client.Commands;

import Client.ResponseHandler;

public abstract class aCommand {
	
	protected ResponseHandler rh;
	
	public aCommand(ResponseHandler rh){
		this.rh = rh;
	}

	public abstract void doCommand();
	
}
