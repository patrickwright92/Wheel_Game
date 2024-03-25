package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int points;
	private int betAmount;
	private BetType betType;

	public SimplePlayer(String playerId, String playerName, int points) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;

	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if (bet < 1) {
			throw new IllegalArgumentException("bet amount must be greater than 0");
		}
		betAmount = bet;
		return true;
	}

	@Override
	public int getBet() {
		return betAmount;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;

	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public void resetBet() {
		this.betType = null;

	}

	@Override
	public String toString()
	{
		return String.format("Player: id=%s, name=%s, betAmount=%s, betType=%s, points=%s", playerId, playerName, betAmount, betType, points);
	}
}
