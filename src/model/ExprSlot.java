package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot{
	
	private Expr expr;
	
	public ExprSlot(Expr expr){
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	@Override
	public boolean isExprSlot() {
		return true;
	}
	@Override
	public double value(Environment env) {
		return expr.value(env);
	}
	public String toString(){
		return expr.toString();
	}
	public String getText(Environment env){
		return String.valueOf(expr.value(env));
	}

}
