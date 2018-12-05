package program;

import computer.Memory;
import inputs.Address;
import inputs.Input;
import inputs.Word;

public class Mul extends BinOp {

	private String toString;

	public Mul(Input left, Input right, Address address) {
		super(left, right, address);
		toString = "Multiply " + left + " and " + right + " into " + address;
	}

	protected void op(Word left, Word right, Word result) {
		result.mul(left.getValue(), right.getValue()); 
	}

	public String toString() {
		return toString;
	}
}
