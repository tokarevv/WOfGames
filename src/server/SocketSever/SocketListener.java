package server.SocketSever;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SocketListener implements Runnable
{  
    private ServerSocket s = null;

    @Override
    public void run() {
     
        try 
        {
            // establish server socket
            s = new ServerSocket(8189);
        
            while (true) {
                Thread t= new ProtocolControl(s.accept());
                t.start();
            }
            
       } catch (IOException ex) 
       {
            Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
}


