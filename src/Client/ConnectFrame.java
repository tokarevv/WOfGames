package Client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConnectFrame extends JFrame {
	
	public ConnectFrame(){
		
		setSize(400, 300);
		setTitle("Connect");
		
		JPanel connectStringPanel = new JPanel(new GridLayout(3, 0));
		//add field for writing in the connection string
		connectStringPanel.add(new JLabel("Connection address and port (for example: 127.0.0.1:8989):"));
		connectStringPanel.add(new JTextField());
		add(connectStringPanel);
		//add connect-button 
		connectStringPanel.add(getConnectButton());
		
		
		addConnectStringPanel();
		
		
	}

	private Component getConnectButton() {
		JButton res = new JButton("Connect");
		res.addActionListener(new ConnectListener());
		return null;
	}

	public class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			

		}

	}	

}
