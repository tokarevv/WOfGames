package Client;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class Players extends AbstractTableModel {

	private List<String> players = new ArrayList<String>();
	private static Players instance = null;
	
	private Players(){}
	
	public static Players getInstance(){
		
		if (instance == null){
			instance = new Players();
		}
		return instance;
		
	}
	
	public List<String> getPlayers() {
		return players;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
		fireTableDataChanged();
	}

	public String get(int index) {
		return players.get(index);
	};

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return players.size();
	}

	public String getColumnName(int column) 
	{
        return "players";
    }  

	@Override
	public Object getValueAt(int row, int col) {
		return players.get(row);
	}

	@Override
    public Class<?> getColumnClass(int column) {                                                               
        return String.class;
    }  	

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	};
	

}
