package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Client.ConnectFrame;
import Client.iResponseHandler;

public class Connector {
	
	//private String address;
	//private int port;
	private Socket fromserver = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	

	public Connector() {}
	
	public void connect(String address, int port) throws UnknownHostException, IOException{

		fromserver = new Socket(address, port);// "91.193.234.248", 8189
		out = new PrintWriter(fromserver.getOutputStream(), true);
	    in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
		
	}

	public void send(String string, iResponseHandler frame) {
		out.println(string);
		out.flush();
		out.println("end command");		
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
		//frame.proceedResponse(response);
		//System.out.println(response);
		
		
	}

}
