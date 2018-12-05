package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;
import util.XLException;

public class SlotFactory {

	private ExprParser exprParser;

	public SlotFactory() {
		this.exprParser = new ExprParser();
	}

	public Slot slot(String input) throws XLException {
		if (comment(input)) {
			return new CommentSlot(input.substring(1));
		}
		try {
			Expr expr = exprParser.build(input);
			return new ExprSlot(expr);
		} catch (IOException e) {
			e.printStackTrace();
			throw (new XLException("Not valid input"));
		}

	}

	public BombSlot bombSlot() {
		return new BombSlot();
	}

	private boolean comment(String input) {
		return input.charAt(0) == '#';
	}
}
