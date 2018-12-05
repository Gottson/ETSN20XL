package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

import expr.Environment;
import expr.Expr;

import util.XLException;

public class XLsheet extends Observable implements Environment {

	private SlotFactory slotFactory;
	private HashMap<String, Slot> map;

	public XLsheet() {
		map = new HashMap<String, Slot>();
		slotFactory = new SlotFactory();

	}

	public String getInput(String address) {
		if (map.containsKey(address)) {
			return map.get(address).toString();
		}
		return "";
	}

	public String getText(String address) {
		if (map.containsKey(address)) {
			return map.get(address).getText(this);
		}
		return "                  ";
	}


	public double value(String address) throws XLException {

		if (map.containsKey(address)) {
			if (map.get(address).isExprSlot()) {
				ExprSlot exprSlot = (ExprSlot) map.get(address);
				Expr expr = exprSlot.getExpr();
				return expr.value(this);
			}
		}
		throw (new XLException("Can only calculate Expressions"));
	}

	public void add(String address, String input) throws XLException {
		Slot oldSlot = null;
		BombSlot bombSlot = slotFactory.bombSlot();

		if (map.containsKey(address)) {
			oldSlot = map.get(address);
		}

		if (input.isEmpty()) {
			map.put(address, bombSlot);
			if (trySheet()) {
				try {
					map.remove(address);
					setChanged();
					notifyObservers();
					return;
				} catch (XLException e) {
					e.printStackTrace();
				}
			}
			map.put(address, oldSlot);
		}

		Slot newSlot = slotFactory.slot(input);

		map.put(address, bombSlot);
		if (newSlot.isExprSlot()) {
			try {
				newSlot.value(this);
				map.put(address, newSlot);
				if (!trySheet()) {
					map.put(address, oldSlot);
					throw (new XLException("Add failed"));
				}
			} catch (XLException e) {
				e.printStackTrace();
				if (oldSlot != null) {
					map.put(address, oldSlot);
					throw (new XLException("Add failed"));
				} else {
					map.remove(address);
					throw (new XLException("Add failed"));
				}
			}
		} else {

			if (trySheet()) {
				map.put(address, newSlot);

			}

		}
		setChanged();
		notifyObservers();

	}

	/*
	 * Testar om man lägger in en kommentar
	 */
	private boolean trySheet() {

		Iterator<Slot> slots = map.values().iterator();
		Slot trySlot;
		while (slots.hasNext()) {
			trySlot = slots.next();
			if (trySlot.isExprSlot()) {
				try {
					trySlot.value(this);
				} catch (XLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public void clear() {
		map.clear();
		setChanged();
		notifyObservers();
	}

	public void save(String fileName) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder(fileName);
		sb.append(".xl");

		XLPrintStream print = new XLPrintStream(sb.toString());
		print.save(map.entrySet());
	}

	public void load(String path) throws FileNotFoundException {
		XLBufferedReader reader = new XLBufferedReader(path);
		reader.load(map, slotFactory);
		setChanged();
		notifyObservers();
	}
}
