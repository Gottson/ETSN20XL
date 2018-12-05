package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLMenuBar;
import model.XLsheet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class XL extends JFrame implements Printable {

	private static final int ROWS = 10, COLUMNS = 8;
	private XLCounter counter;
	CurrentSlot cs;
	private XLList xlList;
	private XLsheet sheet;

	public XL(XL oldXL) {
		this(oldXL.xlList, oldXL.counter);

	}

	public XL(XLList xlList, XLCounter counter) {
		super("Untitled-" + counter);
		XLsheet sheet = new XLsheet();
		cs = new CurrentSlot();
		StatusLabel statusLabel = new StatusLabel(cs);
		this.xlList = xlList;
		this.counter = counter;
		xlList.add(this);
		counter.increment();
		JPanel statusPanel = new StatusPanel(statusLabel, cs);
		JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet, cs);
		Editor editor = new Editor(sheet, cs, statusLabel);
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);
		setJMenuBar(new XLMenuBar(this, xlList, statusLabel, cs, sheet));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		xlList.setChanged();
	}

	public static void main(String[] args) {
		new XL(new XLList(), new XLCounter());
	}
}