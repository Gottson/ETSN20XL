package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.XLsheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private CurrentSlot cs;
	private XLsheet sheet;

	public ClearMenuItem(CurrentSlot cs, XLsheet sheet) {
		
		super("Clear");
		this.cs = cs;
		this.sheet = sheet;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		sheet.add(cs.getAddress(), "");    }
}