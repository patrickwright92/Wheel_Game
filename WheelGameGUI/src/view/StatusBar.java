package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.Player;

public class StatusBar extends JPanel
{
	private JLabel status;
	public StatusBar()
	{
		status = new JLabel("STATUS", JLabel.CENTER);
		add(status);
	}
	
	//updating label to player added
	public void updateAddPlayer(Player player)
	{
		status.setText("PLAYER ID: "+player.getPlayerId()+" ADDED");
	}
	
	//updating label to player removed
	public void updateRemovePlayer(Player player)
	{
		status.setText("PLAYER ID: "+player.getPlayerId()+" REMOVED");
	}
	
	//updating label to player placed a bet
	public void updateMakeBet(Player player)
	{
		status.setText("PLAYER ID: "+player.getPlayerId()+" HAS PLACED A BET");
	}
	
	//updating label to spinning
	public void updateSpinning()
	{
		status.setText("SPINNING");
	}
	
	//updating label to winning slot details
	public void updateResult(String slot)
	{
		status.setText(slot);
	}
}
