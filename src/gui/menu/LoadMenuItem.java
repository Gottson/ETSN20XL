package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.XLsheet;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	private XLsheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, XLsheet sheet) {
		super(xl, statusLabel, "Load");
		this.sheet = sheet;
	}

	protected void action(String path) throws FileNotFoundException {
		sheet.load(path);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}