package computer;

import inputs.Word;

public interface WordFactory<T extends Word> {

	public T word(String word);
	
}
