package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	
	//setup java logging using properties file google - configure log property file (oracle - using the jre logging configuration file)
	
	public GameEngineImpl() {
		
		//TODO returning hex because I do not have a toString method
	}
	 
	
	private List<Player> players = new ArrayList<>();
	private List<GameEngineCallback> gameEngineCallbacks = new ArrayList<>();
	private Collection<Slot> slots = new ArrayList<>();
	

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		
		for(int i = initialDelay; i <= finalDelay+1; i+=delayIncrement) {
			// debug code System.out.println(i);
			//delay goes to 101 at the moment
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		
	}

	@Override
	public void calculateResult(Slot winningSlot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayer(Player player) {
		//check if player already exists, and if it does; replace it.
		for (Player p : players) {
			if(player.equals(p)) {
				players.set(players.indexOf(p), player);
			} else {
				//if player does not already exist add it
				players.add(player);
			}
		}
	}

	@Override
	public Player getPlayer(String id) {
		//idValue initializer
		Player idValue = null;
		//check to see if String id matches any Player id
		for (Player p : players) {
			if (id.equals(p)) {
		//if match set idValue to Player id		
				idValue = p;
			}
		}
		//return Player id, if match was not found return null
		return idValue;
		
	}

	@Override
	public boolean removePlayer(Player player) {
		for (Player p : players) {
			if (player.equals(p)) {
				players.remove(p);	
			}	
		}
		return true;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		//i need a loop to iterate through callbacks - unsure at this stage what it means
		/* if i need to validate
		for (GameEngineCallback g : gameEngineCallbacks) {
			
		} */
		gameEngineCallbacks.add(gameEngineCallback);
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		//basic code need to further implement
		gameEngineCallbacks.remove(gameEngineCallback);
		return true;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Slot> getWheelSlots() {
		
		Color color = null;
		int slotNumber[] = {00, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2, 0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1};

		for(int i = 0; i < Slot.WHEEL_SIZE-1; i++ ) {
			if (i == 0) {
				color = Color.GREEN00;
			} else if (i == 19) {
				color = Color.GREEN0;	
			} else if (i % 2 == 0) {
				color = Color.BLACK;
			} else {
				color = Color.RED;
			}
			SlotImpl slot = new SlotImpl(i, color, slotNumber[i]);
			slots.add(slot);		
		}
		
		return slots;
	}
	
	

}
