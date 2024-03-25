package modelview;

import java.util.HashMap;
import java.util.Map;

public class CalculateWinLoss 
{
	private Map<String, Integer> playerOldPoints = new HashMap<String, Integer>();
	private Map<String, Integer> playerNewPoints = new HashMap<String, Integer>();
	//setting the points before the bet
	public void setOldPoints(String id,int points)
	{
		playerOldPoints.put(id, points);
	}
	
	//setting the points after the bet
	public void setNewPoints(String id,int points)
	{
		playerNewPoints.put(id, points);
	}
	
	//calculating the win/loss for each round for each player
	public int getWinLoss(String id)
	{
		int winLoss=0;
		if(playerNewPoints.get(id)!=null && playerOldPoints.get(id)!=null)
		{
			winLoss=playerNewPoints.get(id)-playerOldPoints.get(id);
		}
		return winLoss;
	}
}
