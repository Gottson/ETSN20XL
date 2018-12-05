package model;

import expr.Environment;
import util.XLException;

public class BombSlot implements Slot {
	
	public String getSlot() {
		throw new XLException("Wrong input");
	}
	public double value(Environment env) {
		throw (new XLException("Wrong input"));
	}
	public boolean isExprSlot() {
		return false;
	}
	public String getText(Environment env) {
		throw (new XLException("Wrong input"));
	}
}
