package server.webServer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WebServer implements Runnable
{  private ServerSocket s = null;

    @Override
    public void run() {

    		// establish HTTP - server socket
            ServerSocket s;
			try {
				s = new ServerSocket(8080);
				
				while (true) {
	                Thread t= new WebServerListener(s.accept());
	                t.start();
	            }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

   }

    
}


