package inputs;

import computer.Memory;

public class LongWord implements Word<Long> {

	Long longWord;

	public LongWord(Long longWord) {
		this.longWord = longWord;
	}

	public Long getValue() {
		return longWord;
	}

	public void add(Long leftWord, Long rightWord) {
		longWord = leftWord + rightWord;
	}

	public void mul(Long leftWord, Long rightWord) {
		longWord = leftWord * rightWord;
	}

	public Word<Long> getWord(Memory memory) {
		return this;
	}

	public void set(Long longWord) {
		this.longWord = longWord;
	}

	public String toString() {
		return longWord.toString();
	}


}
