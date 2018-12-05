package inputs;

import computer.Memory;

public class ByteWord implements Word<Byte> {

	private Byte byteWord;

	public ByteWord(Byte byteWord) {
		this.byteWord = byteWord;
	}

	public Byte getValue() {
		return byteWord;

	}

	public void add(Byte leftWord, Byte rightWord) {
		byteWord = (byte) (rightWord + leftWord);
	}

	public void mul(Byte leftWord, Byte rightWord) {
		byteWord = (byte) (leftWord*rightWord);
	}

	public Word<Byte> getWord(Memory memory) {
		return this;
	}

	public void set(Byte byteWord) {
		this.byteWord = byteWord;
	}

	public String toString() {
		return byteWord.toString();
	}
}