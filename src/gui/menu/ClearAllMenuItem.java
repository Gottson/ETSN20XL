package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.XLsheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {

	private XLsheet sheet;

	public ClearAllMenuItem(XLsheet sheet) {
		super("Clear all");
		this.sheet = sheet;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		sheet.clear();
	}
}