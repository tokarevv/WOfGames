package Client.Commands;

import javax.swing.JOptionPane;

import Client.ListFrame;
import Client.ResponseHandler;
import Controller.aCommand;

public class RefuseGameCommand extends aCommand {

	public RefuseGameCommand(ResponseHandler rh) {
		super(rh);
	}

	@Override
	public void doCommand() {
		JOptionPane.showMessageDialog(ListFrame.getInstance(), "Player has refused your suggestion.");
	}

}
