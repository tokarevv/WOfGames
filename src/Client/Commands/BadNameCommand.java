package Client.Commands;

import javax.swing.JOptionPane;

import Client.ConnectFrame;
import Client.ResponseHandler;
import Controller.aCommand;

public class BadNameCommand extends aCommand {

	public BadNameCommand(ResponseHandler rh) {
		super(rh);
	}

	@Override
	public void doCommand() {
		JOptionPane.showMessageDialog(ConnectFrame.getInstance(), "This login is not unique. Try another one.");
	}

}
