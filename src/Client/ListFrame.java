package Client;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ListFrame extends JFrame {
	
	private Players players = Players.getInstance();
	private Games games = Games.getInstance();
	
	public ListFrame(){
		
		setSize(400, 300);
		setLocation(50, 50);
		setTitle("List frame");
		
	}
	
	

}
