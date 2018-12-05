package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer{
	private CurrentSlot cs;
	
    public CurrentLabel(CurrentSlot cs) {
        super("A1", Color.WHITE);
        this.cs = cs;
        cs.addObserver(this);
    }
    public void setCurrentLabel(CurrentSlot cs){
    	this.cs = cs;
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(cs.getAddress());
	}
}