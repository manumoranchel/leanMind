package leanMind.katas;

public class PhraseSplit {

	private static final String NEW_LINE_CHARACTER = "/n";
	private static final String CHAR_TO_REPLACE = " ";
	

	public Object split(String phrase, int columnNumber) {
		
		if (columnNumber > phrase.length()) {
			return phrase;
		}
		
		int newLinePosition = findLastBlankBeforeColumnNumber(phrase, columnNumber);
		
		if (newLinePosition == -1) {
			newLinePosition = columnNumber;
		}
		
		StringBuilder processedPhrase = new StringBuilder();
		processedPhrase.append(phrase.substring(0, newLinePosition));
		processedPhrase.append(NEW_LINE_CHARACTER);
		processedPhrase.append(phrase.substring(newLinePosition, phrase.length()));
		
		if (' ' == phrase.charAt(newLinePosition)) {
			processedPhrase.deleteCharAt(newLinePosition + NEW_LINE_CHARACTER.length());
		}
		
		return processedPhrase.toString();
	}

	private int findLastBlankBeforeColumnNumber(String phrase, int columnNumber) {
		
		String columnLimitedRawPhrase = phrase.substring(0,columnNumber);
		return columnLimitedRawPhrase.lastIndexOf(CHAR_TO_REPLACE);
	}

}
