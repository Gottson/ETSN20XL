package program;

import computer.Memory;

public interface Instruction {

	/**
	 * Excecute an instruction
	 *  @param memory reference to the memory so that instructions can make changes in the memory
	 *  @param progCounter  reference to the program counter so that instructions can change the counter
	 */
	public void execute(Memory memory, ProgramCounter progCounter);
	
	public String toString();
		
}
