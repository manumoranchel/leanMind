package leanMind.katas;

public class StringCalculator {

	private static final String DEFAULT_SEPARATOR = ",";
	private static final String EMBEDDED_SEPARATOR_BEGIN = "//";
	private static final String EMBEDDED_SEPARATOR_END = ";";

	protected int calculateString(String stringToCalculate) {

		int sum = 0;
		String separator = fetchSeparator(stringToCalculate);

		String stringToCalculatedTrimmed = stringToCalculate;
		
		if (!separator.equals(DEFAULT_SEPARATOR)) {
			int lastPositionSeparator = stringToCalculate.indexOf(EMBEDDED_SEPARATOR_END) + 1;
			stringToCalculatedTrimmed = stringToCalculate.substring(lastPositionSeparator);
		}
		
		for (String currentGroup : stringToCalculatedTrimmed.split(separator)) {
			sum += singleGroupValue(currentGroup);
		}
		return sum;
	}

	protected String fetchSeparator(String stringToCalculate) {

		if (stringToCalculate.startsWith(EMBEDDED_SEPARATOR_BEGIN)
				&& stringToCalculate.contains(EMBEDDED_SEPARATOR_END)) {

			int beginSeparator = stringToCalculate.indexOf(EMBEDDED_SEPARATOR_BEGIN);
			beginSeparator += EMBEDDED_SEPARATOR_BEGIN.length();
			int endSeparator = stringToCalculate.indexOf(EMBEDDED_SEPARATOR_END);

			return stringToCalculate.substring(beginSeparator, endSeparator);
		} else
			return DEFAULT_SEPARATOR;
	}

	protected int singleGroupValue(String stringToCalculate) {
		String trimmedString = stringToCalculate.trim();
		try {
			return Integer.parseInt(trimmedString);
		} catch (NumberFormatException e) {
			System.out.println("Found a non numeric value");
		}
		return 0;
	}

}
