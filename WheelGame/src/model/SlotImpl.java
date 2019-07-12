package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {

	private int position;
	private int number;
	private Color color;

	public SlotImpl(int position, Color color, int number) {
		this.position = position;
		this.color = color;
		this.number = number;
		
		//this constructor creates one slot on the wheel. use gameEngineImpl to setup the entire wheel
	}

	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean equals(Slot slot) {
		//slot is the position?
		//based on position in collection, confirm number and color match.
		
		//return true is colour and number fields are correct.
		return false;
	}

}
