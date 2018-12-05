package program;

import inputs.Address;
import inputs.Input;
import inputs.Word;

public class Add extends BinOp {

	private String toString;

	public Add(Input left, Input right, Address address) {
		super(left, right, address);
		toString = "add " + left + " and " + right + " into " + address;
	}

	protected void op(Word left, Word right, Word result ) {
		result.add(left.getValue(), right.getValue());
	}

	public String toString() {
		return toString;
	}

}