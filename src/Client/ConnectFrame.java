package Client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Connector;

@SuppressWarnings("serial")
public class ConnectFrame extends JFrame {
	
	private JPanel connectPanel;
	private JTextField server = new JTextField();
	private JTextField port = new JTextField();
	private JTextField login = new JTextField();
	private Connector conn = new Connector();
	
	public ConnectFrame(){
		
		setSize(400, 150);
		setTitle("Connect");
		setLayout(new BorderLayout());
		
		addLoginPanel();
		addConnectPanel();
		//add connect-button 
		add(getConnectButton(), BorderLayout.SOUTH);
	}

	private void addLoginPanel() {
		connectPanel = new JPanel(new BorderLayout());
		//add field for writing in the connection string
		connectPanel.add(new JLabel("Login:"), BorderLayout.WEST);
		connectPanel.add(login, BorderLayout.CENTER);
		add(connectPanel, BorderLayout.NORTH);
	}

	private void addConnectPanel() {
		connectPanel = new JPanel(new GridLayout(2, 0));
		//add field for writing in the connection string
		connectPanel.add(new JLabel("Connection address and port (for example: 127.0.0.1:8989):"));
		connectPanel.add(server);
		add(connectPanel, BorderLayout.CENTER);
	}

	private void setInvisible() {
		
		setVisible(false);
		
	}
	
	private Component getConnectButton() {
		JButton res = new JButton("Connect");
		res.addActionListener(new ConnectListener());
		return res;
	}

	class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFrame f = new ListFrame();//GameFrame.get;
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			connect();
			setInvisible();
			f.setVisible(true);
			
		}

		private void connect() {
			conn = new Connector(server.getText());
			try {
				conn.connect();
				conn.send("ConnectMe:"+login.getText());
			} catch (UnknownHostException e) {
				System.out.println("Couldn't establish a connection: Unknown Host!");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			System.out.println("Couldn't establish a connection");
			
		}

	}	

}
