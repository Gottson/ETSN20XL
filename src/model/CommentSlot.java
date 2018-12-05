package model;

import expr.Environment;
import util.XLException;

public class CommentSlot implements Slot{
	
	private String comment;
	
	public CommentSlot(String comment){
		this.comment = comment;
	}
	
	public String getText(Environment env){
		return comment;
	}

	@Override
	public boolean isExprSlot() {
		return false;
	}

	@Override
	public double value(Environment env) {
		throw (new XLException("Wrong input"));
	}
	
	public String toString(){
		return "#" + comment;
	}

}
