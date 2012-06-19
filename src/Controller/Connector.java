package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Client.IncomeListener;

public class Connector {
	
	private Socket fromserver = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private static Connector instance = null;
	

	private Connector() {}
	
	public static Connector getInstance(){
		
		if (instance == null){
			instance = new Connector();
		}
		return instance;
		
	}	
	public void connect(String address, int port) throws UnknownHostException, IOException{

		fromserver = new Socket(address, port);// "91.193.234.248", 8189
		out = new PrintWriter(fromserver.getOutputStream(), true);
	    in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
		
		initIncomeListener();
		
	}
	
	private static void initIncomeListener() {
		IncomeListener incListener =  IncomeListener.getInstance();
		Thread t = new Thread(incListener);
		t.start();
	}

	public void send(String string) {
		out.println(string);
		out.flush();
		out.println("endCommand");		
		System.out.println("Command sent - "+string);
	}

	public String getResponse() throws IOException {

		if (fromserver.isClosed()){
			System.out.println("WTF!?!?!? Socket's closed!!!");
			return "";
		}
	    
		String input, response = "";

		//получаем ответ, сложить ответ в кучу...
		while ((input = in.readLine())!=null) {
			if (input.contains("endResponse")) {
				break;
			}
			
			response += input;
		}
		return response;
		
		
	}

	public boolean isClosed() {
		return fromserver.isClosed();
	}

}
