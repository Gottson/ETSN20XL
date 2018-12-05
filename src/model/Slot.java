package model;

import expr.Environment;

public interface Slot {
	public boolean isExprSlot();
	public String getText(Environment env);
	public double value(Environment env);
}
