package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentSlot extends Observable {
	SlotLabel cs;

	public CurrentSlot() {
		cs = null;
	}

	public void setCurrentSlot(SlotLabel slotLabel) {
		if (cs != null) {
			cs.setBackground(Color.WHITE);
		}
		cs = slotLabel;
		cs.setBackground(Color.YELLOW);
		setChanged();
		notifyObservers();
	}

	public String getAddress() {
		return cs.getAddress();
	}

	public void setText(String input) {
		cs.setText(input);
		setChanged();
		notifyObservers();
	}

	public String getText() {
		return cs.getText();
	}


}
