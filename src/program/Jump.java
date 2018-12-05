package program;

import computer.Memory;

public class Jump implements Instruction{
	private int index;
	private String toString;
	
	public Jump(int index){
		this.index = index - 1;
		toString = "Jump to " + index;
	}

	public void execute(Memory memory, ProgramCounter progCounter) {
		progCounter.jump(index);
	}
	public String toString(){
		return toString;
	}
	
}
