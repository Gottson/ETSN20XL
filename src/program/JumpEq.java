package program;

import computer.Memory;
import inputs.Input;

public class JumpEq implements Instruction {

	private int index;
	private Input left;
	private Input right;
	private String toString;

	public JumpEq(int index, Input left, Input right) {
		this.index = index - 1;
		this.left = left;
		this.right = right;
		toString = "Jump to " + index + " if " + left + " == " + right;
	}

	public void execute(Memory memory, ProgramCounter progCounter) {
		
		if (left.getWord(memory).getValue().compareTo(right.getWord(memory).getValue()) == 0) {
			progCounter.jump(index);
		}
	}
	public String toString(){
		return toString;
	}
}
