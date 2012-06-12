package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
	
	private String address;
	private int port;
	private Socket fromserver = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	

	public Connector() {}
	
	

	public void connect(String address, int port) throws UnknownHostException, IOException{

		fromserver = new Socket(address, port);
		out = new PrintWriter(fromserver.getOutputStream(), true);
	    in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
		
	}

}
