package computer;

import inputs.ByteWord;

public class ByteWordFactory implements WordFactory<ByteWord>{
		
	public ByteWord word(String word) {
			if (word == null){
				return new ByteWord(null);
			}
		return new ByteWord(Byte.parseByte(word));
	}
}
