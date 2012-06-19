package Client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Connector;

@SuppressWarnings("serial")
public class ConnectFrame extends JFrame {
	
	public static final String DEFAULT_LOGIN = "empty";
	public static final String DEFAULT_ADDRESS = "192.168.0.113";//"213.227.229.148";//
	public static final String DEFAULT_PORT = "8189";
	
	private JPanel connectPanel;
	private JTextField server = new JTextField(DEFAULT_ADDRESS);
	private JTextField port = new JTextField(DEFAULT_PORT);
	private JTextField login = new JTextField(DEFAULT_LOGIN);
	private Connector conn = Connector.getInstance();

	private static ConnectFrame instance = null;
	
	public static ConnectFrame getInstance(){
		
		if (instance == null){
			instance = new ConnectFrame();
		}
		return instance;
		
	}
	
	private ConnectFrame(){
		
		setSize(400, 120);
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
		connectPanel.add(new JLabel("Connection address:"));
		connectPanel.add(server);
		connectPanel.add(new JLabel("Connection port:"));
		connectPanel.add(port);
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

	private void connect() throws NumberFormatException, UnknownHostException, IOException {
		conn = Connector.getInstance();
		conn.connect(server.getText(), Integer.parseInt(port.getText()));
		
		conn.send("ConnectMe:"+login.getText());
		//conn.send("SuggestGame:X0,"+login.getText());
		
		//proceedResponse(conn.getResponse());
		//proceedResponse("playerList:Vasya, Kuzzya");
	}

	class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {

			try {
				connect();
			} catch (ConnectException e) {
				System.out.println("Couldn't establish a connection: Connection refused!");
			} catch (UnknownHostException e) {
				System.out.println("Couldn't establish a connection: Unknown Host!");
				//e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
}
