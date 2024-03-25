package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	
	private List<Player> players = new ArrayList<>();
	private List<GameEngineCallback> gameEngineCallbacks = new ArrayList<>();
	private Collection<Slot> slots = new ArrayList<>();

	public GameEngineImpl() {
		
	}

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		
		for(int i = initialDelay; i <= finalDelay+1; i+=delayIncrement) {
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void calculateResult(Slot winningSlot) {

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
		for (Player p : players) {
			if (p.getPlayerId().equals(id)) {
				return p;
			}
		}
		System.out.println("Player not found GetPlayer method");
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		for (Player p : players) {
			if (player.equals(p)) {
				players.remove(p);
				System.out.println("Player removed");
				return true;	
			}	
		}
		System.out.println("Player not found");
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for (GameEngineCallback g : gameEngineCallbacks) {
			if (g.equals(gameEngineCallback)) {
				return;
			}
		} 
		gameEngineCallbacks.add(gameEngineCallback);
		System.out.println("GameEngineCallback added");
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for (GameEngineCallback g : gameEngineCallbacks) {
			if(g.equals(gameEngineCallback)) {
				gameEngineCallbacks.remove(gameEngineCallback);
				System.out.println("GameEngineCallback removed");
				return true;
			}
		}
		System.out.println("GameEngineCallback not found");
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		// If the player exists, place the bet
		for (Player p : players) {
			if (p.getPlayerId().equals(player.getPlayerId())) {
				player.setBetType(betType);
				player.setBet(bet);
				System.out.println("Player Bet Type and Amount set");
				return true;
			}
		}
		System.out.println("Player does not exist PlaceBet method");
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
