package computer;

import inputs.Word;

public class Memory {
	private WordFactory wf;
	private Word[] memory;
	
	public Memory(int size, WordFactory wf) {
		this.wf = wf;
		memory = new Word[size];
		for (int i = 0; i < size; i++){
			memory[i] = wf.word(null);
		}
	}
	
	public Word getWord(int index) {
		return memory[index];
	}
	
}
