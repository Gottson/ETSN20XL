package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.XLsheet;

	

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	
	private String address;
	private CurrentSlot cs;
	private XLsheet sheet;
    public SlotLabel(String address, CurrentSlot cs, XLsheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.cs = cs;
        this.address = address;
        this.sheet = sheet;
        cs.addObserver(this);
        sheet.addObserver(this);
    }
    public String getAddress(){
    	return address;
    }
	public void mouseClicked(MouseEvent e){
		cs.setCurrentSlot(this);
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(sheet.getText(address));
	}

}