package program;

public class ProgramCounter {
	private int index;

	public ProgramCounter() {
		index = 0;
	}

	protected void next() {
		if (index != -1) {
			index++;
		}
	}

	protected void jump(int index) {
		this.index = index;
	}

	protected int get() {
		return index;
	}
}
