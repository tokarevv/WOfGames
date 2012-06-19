package Client;

import java.io.IOException;
import javax.swing.JOptionPane;

import Client.Commands.CommandFactory;
import Client.Commands.WrongCommandTypeException;
import Controller.Connector;

public class IncomeListener  implements Runnable {

	//private List<String> players = new ArrayList<String>();
	private static IncomeListener instance = null;
	
	private IncomeListener(){}
	
	public static IncomeListener getInstance(){
		
		if (instance == null){
			instance = new IncomeListener();
		}
		return instance;
		
	}
	
	public void run(){
		Connector conn = Connector.getInstance();
		while (true){
			try {
				proceedResponse(conn.getResponse());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

	
	public void proceedResponse(String response) {
		
		ResponseHandler rh = new ResponseHandler(response);
		try {
			CommandFactory.getCommand(rh).doCommand();
		} catch (WrongCommandTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
