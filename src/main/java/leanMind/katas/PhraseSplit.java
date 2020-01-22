package leanMind.katas;

public class PhraseSplit {

	private static final Object NEW_LINE_CHARACTER = "/n";

	public Object split(String phrase, int columnNumber) {
		
		if (columnNumber > phrase.length()) {
			return phrase;
		}
		
		int newLinePosition = columnNumber;
		
		StringBuilder processedPhrase = new StringBuilder();
		processedPhrase.append(phrase.substring(0, newLinePosition));
		processedPhrase.append(NEW_LINE_CHARACTER);
		processedPhrase.append(phrase.substring(newLinePosition, phrase.length()));
		
		return processedPhrase.toString();
	}

}
