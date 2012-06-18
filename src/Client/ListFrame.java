package Client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Connector;

@SuppressWarnings("serial")
public class ListFrame extends JFrame  implements iResponseHandler{
	
	private Players players = Players.getInstance();
	private Games games = Games.getInstance();
	private	JTable playersTable = null;
	private JScrollPane jsp = null;
	private	JTable gamesTable = null;
	private JScrollPane gjsp = null;
	private JPanel listsPanel = new JPanel(new GridLayout(1,2));
	private Connector conn = Connector.getInstance();

	
	public ListFrame(){
		
		setSize(400, 300);
		setLocation(50, 50);
		setTitle("List frame");
		
		add(new JLabel("Choose a game", JLabel.CENTER), BorderLayout.NORTH);
		add(listsPanel, BorderLayout.CENTER);
		//setLayout(new GridLayout(1, 2));
		
		addPlayersTable();
		addGamesTable();
		
		addButtons();
		
	}
	
	private void addButtons() {
		JButton suggestGameButton = new JButton("Suggest a geme");
		suggestGameButton.addActionListener(new SuggestGameListener());
		add(suggestGameButton, BorderLayout.SOUTH);
	}

	public void setPlayerList(String[] players){
		
		this.players.setPlayers(Arrays.asList(players));
		
	}

	private void addGamesTable() {
		gamesTable = new JTable();
		gamesTable.setModel(games);
		gjsp = new JScrollPane(gamesTable);
		listsPanel.add(gjsp);
	}
	
	private void addPlayersTable() {
		playersTable = new JTable();
		playersTable.setModel(players);
		jsp = new JScrollPane(playersTable);
		listsPanel.add(jsp);
	}

	private void showMessage(String string) {
		JOptionPane.showMessageDialog(this, string);
	}
	
	private void doSuggestGame() {
		if  (!isGameAndPlayerSelected()){
			return;
		}
		
		conn.send("SuggestGame:"+games.get(gamesTable.getSelectedRow())+","+players.get(playersTable.getSelectedRow()));
		
	}
	
	@Override
	public void proceedResponse(String response) {
		ResponseHandler rh = new ResponseHandler(response);
		
		String command = rh.getCommand();
		System.out.println(command);
		System.out.println(response);
		
		if (command.trim().toLowerCase().equals("refuseGame")){
			JOptionPane.showMessageDialog(this, "Player has refused your suggestion.");
		}
		else{
			String[] params = rh.getParams();
			if (params.length != 3){
				//smth is wrong
			}
			//aGameAPI game = GameFactory.getGame(params[0]);
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setVisible(false);
			//f.setVisible(true);
			//f.setPlayerList(rh.getParams());
			
		}
	}
	private boolean isGameAndPlayerSelected() {
		boolean res = true;
		if (gamesTable.getSelectedRow() == -1){
			showMessage("No game is selected. Please, select one and try again.");
			res = false;
		}
		if (playersTable.getSelectedRow() == -1){
			showMessage("No player is selected. Please, select one and try again.");
			res = false;
		}
		return res;
	}

	class SuggestGameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (conn.isClosed()){
				showMessage("For some reason connection is lost. Try to reconnect.");
			}
			else{
				doSuggestGame();
			}
			
		}

	}

}
