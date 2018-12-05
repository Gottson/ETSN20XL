package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.XLsheet;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
	private XLsheet sheet;
    public SaveMenuItem(XL xl, StatusLabel statusLabel, XLsheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
       sheet.save(path);
       statusLabel.setText("Saved");
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}