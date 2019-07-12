package model.enumeration;

import model.interfaces.Player;
import model.interfaces.Slot;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */
public enum BetType {
	RED {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			//what to do with player, and one winning slot - check what type player has bet
			//compare with winning slot, if win do apply if lose apply
			//create logic for the table on page 1 of assignment
		}
	},
	BLACK {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {

		}
	},
	GREEN0 {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {

		}
	},
	GREEN00 {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {

		}
	};


	/**
	 * This method is to be overridden for each bet type<br>
	 * see assignment specification for betting odds and how win/loss is applied
	 * 
	 * @param player  - the player to apply the win/loss points balance adjustment
	 * @param winSlot - the winning slot the ball landed on
	 */
	public abstract void applyWinLoss(Player player, Slot winSlot);
}