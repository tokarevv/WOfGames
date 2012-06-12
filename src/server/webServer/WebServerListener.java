
package server.webServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class WebServerListener extends Thread {
    private final Socket incoming;
    
    WebServerListener(Socket accept) {
        incoming = accept;
    }

    @Override
    public void run() {

         try
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();       
         
            BufferedReader in;
            StringBuilder sb = new StringBuilder();
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
            
            File file = new File("index.html");
            in = new BufferedReader(new FileReader(file));
            String s;
            while((s=in.readLine())!=null){   
                sb.append(s);
            }
            in.close(); 
            out.println(sb.toString());

        }
        catch(IOException ex) {
                Logger.getLogger(WebServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                incoming.close();
            } catch (IOException ex) {
                Logger.getLogger(WebServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
