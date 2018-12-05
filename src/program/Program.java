package program;

import java.util.ArrayList;
import java.util.List;

import computer.Memory;

public abstract class Program {

	private List<Instruction> instructions;
	private ProgramCounter progCounter;
	int size;
	StringBuilder sb;

	public Program() {
		progCounter = new ProgramCounter();
		instructions = new ArrayList<Instruction>();
		size = 0;
		sb = new StringBuilder();
	}

	protected void add(Instruction instruction) {
		instructions.add(instruction);
		sb.append(size + ": " + instruction.toString() + "\n");
		size++;
	}

	public void execute(Memory memory) {
		while (progCounter.get() != -1) {
			instructions.get(progCounter.get()).execute(memory, progCounter);
			progCounter.next();
		}
	}

	public String toString() {
		return sb.toString();
	}
}
