package Client;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Games extends AbstractTableModel{

	private List<String> games = new ArrayList<String>();
	private static Games instance = null;
	
	private Games(){
		games.add("X0");
	}
	
	public static Games getInstance(){
		
		if (instance == null){
			instance = new Games();
		}
		return instance;
		
	}
	
	
	public List<String> getGames() {
		return games;
	}

	public void setGames(List<String> players) {
		this.games = players;
	}

	public String get(int index) {
		return games.get(index);
	};

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return games.size();
	}

	public String getColumnName(int column) 
	{
        return "games";
    }  

	@Override
	public Object getValueAt(int row, int col) {
		return games.get(row);
	}

	@Override
    public Class<?> getColumnClass(int column) {                                                               
        return String.class;
    }  	

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}
