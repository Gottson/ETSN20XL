package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLsheet;
import util.XLException;

public class Editor extends JTextField implements ActionListener, Observer{

	private CurrentSlot cs;
	private XLsheet sheet;
	private StatusLabel sb;
	
    public Editor(XLsheet sheet, CurrentSlot cs, StatusLabel sb) {
        setBackground(Color.WHITE);
        addActionListener(this);
        this.cs = cs;
        this.sb = sb;
        this.sheet = sheet;
        cs.addObserver(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sheet.add(cs.getAddress(), getText());	
		} catch (XLException exc){
			sb.setText(exc.getMessage());
		}
	}

	public void update(Observable arg0, Object arg1) {
		setText(sheet.getInput(cs.getAddress()));
	} 
}