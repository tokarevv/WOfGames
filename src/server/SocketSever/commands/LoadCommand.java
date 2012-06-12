
package server.SocketSever.commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import server.SocketSever.iCommand;

public class LoadCommand implements iCommand{
    OutputStream outStream;

    public LoadCommand(OutputStream outStream) {
        this.outStream = outStream;
    }

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
    
   
    
}
