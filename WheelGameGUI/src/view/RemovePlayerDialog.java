package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DialogCancelButtonActionListener;
import controller.RemovePlayerDialogOkButtonActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RemovePlayerDialog extends JDialog 
{
	private JButton okButton;
	private JButton cancelButton;
	
	public RemovePlayerDialog(Frame frame, Player player, GameEngine gameEngine, SummaryPanel summary, StatusBar status)
	{
		//setting the frame to the middle of the screen
		setLocationRelativeTo(null);
		//makes the dialog box unresizable
		setResizable(false);		
		//creating panel to contain input panel and button panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		//creating the panel to contain all the elements of input
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		JLabel confirmationLabel = new JLabel("Are you sure you want to remove player ID: "+player.getPlayerId()+"?");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(confirmationLabel, gbc);
		JLabel spacer = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		inputPanel.add(spacer,gbc);
		//creating a panel for buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2, 10, 10));
		okButton = new JButton("OK");
		//adding a listener to ok button
		okButton.addActionListener(new RemovePlayerDialogOkButtonActionListener(this, player,gameEngine, status, summary));
		buttonPanel.add(okButton);
		cancelButton = new JButton("Cancel");
		//adding a listener to cancel button
		cancelButton.addActionListener(new DialogCancelButtonActionListener(this));
		buttonPanel.add(cancelButton);
		panel.add(inputPanel, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		getContentPane().add(panel);
		pack();
		this.setVisible(true);
	}	
}
