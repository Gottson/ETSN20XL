package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.XLsheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, XLsheet sheet, CurrentSlot cs) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, sheet, cs));
    }
}