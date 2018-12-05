package program;

import computer.Memory;
import inputs.Address;
import inputs.Input;

public class Copy implements Instruction {

	private Input input;
	private Address address;
	private String toString;

	public Copy(Input input, Address address) {
		this.input = input;
		this.address = address;
		toString = "Copy " + input + " to " + address;
	}

	public void execute(Memory memory, ProgramCounter progCounter) {
		address.getWord(memory).set(input.getWord(memory).getValue());
	}

	public String toString() {
		return toString;
	}
}