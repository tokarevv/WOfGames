package Client;

import javax.swing.JFrame;

public class JClient {

	public static void main(String[] args){
		
		JFrame f = ConnectFrame.getInstance();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//f.setVisible(false);
	}
	
}
