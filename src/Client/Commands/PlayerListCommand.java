package Client.Commands;

import javax.swing.JFrame;

import Client.ConnectFrame;
import Client.ListFrame;
import Client.ResponseHandler;

public class PlayerListCommand extends aCommand {

	public PlayerListCommand(ResponseHandler rh) {
		super(rh);
	}

	@Override
	public void doCommand() {
		ListFrame f = ListFrame.getInstance();// GameFrame.get;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConnectFrame.getInstance().setVisible(false);
		f.setVisible(true);
		f.setPlayerList(rh.getParams());
	}

}
