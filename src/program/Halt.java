package program;

import computer.Memory;

public class Halt implements Instruction{
	private static final String toString = "Halt";
	
	public void execute(Memory memory, ProgramCounter progCounter) {
		progCounter.jump(-1);
	}
	
	public String toString(){
		return toString;
	}
}
