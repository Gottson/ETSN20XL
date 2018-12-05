package program;

import computer.Memory;
import inputs.Address;
import inputs.Input;
import inputs.Word;

public abstract class BinOp implements Instruction {

	private Input left;
	private Input right;
	private Address address;

	public BinOp(Input left, Input right, Address address) {
		this.left = left;
		this.right = right;
		this.address = address;
	}

	abstract protected void op(Word left, Word right, Word result);

	public void execute(Memory memory, ProgramCounter progCounter) {

		Word result = address.getWord(memory);
		Word inputLeft = left.getWord(memory);
		Word inputRight = right.getWord(memory);
		op(inputLeft, inputRight, result);

	}
}