
package server.SocketSever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.SocketSever.commands.LoadCommand;

class ProtocolControl extends Thread {
    private final Socket incoming;
    
    ProtocolControl(Socket accept) {
        incoming = accept;
    }

    @Override
    public void run() {

         try
         {
            InputStream  inStream  = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);
         
            if(in.hasNextLine())
            {
                iCommand c = null;
                String type = in.nextLine();
                
                if(type.equals("save")){
                   // c = new SaveCommand(in);
                }
                else if(type.equals("load")){
                    c = new LoadCommand(outStream);
                }
                else if(type.equals("saveImage")){
                   // c = new SaveImageCommand(in);
                }
                
                if(c!=null ) c.execute();
            
            }

            
         }
         catch(IOException ex) {
                Logger.getLogger(ProtocolControl.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally
         {
            try {
                incoming.close();
            } catch (IOException ex) {
                Logger.getLogger(ProtocolControl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
