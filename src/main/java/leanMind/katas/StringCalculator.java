package leanMind.katas;

public class StringCalculator {

	private static final String DEFAULT_SEPARATOR = ",";
	private static final String EMBEDDED_SEPARATOR_BEGIN = "//";
	private static final String EMBEDDED_SEPARATOR_END = ";";

	/**
	 * For a given String, calculate the sum of the values present in it. Values
	 * will be separated by <code>,</code> by default. The String can optionally
	 * contain a separator at the beginning. The separator will be within the start
	 * separator code <code>//</code> and the end separator code <code>;</code>. If
	 * the String contains a non-numeric value, 0 will be assumed for it.
	 * 
	 * @param stringToCalculate The String with the numbers and optionally the
	 *                          separator.
	 * @return Addition of the valued within the String received.
	 */
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

	/**
	 * Evaluate the String received to determine if there is a separator present. If
	 * present, return it.
	 * 
	 * @param stringToCalculate the String to evaluate
	 * @return The separator if existing, default separator otherwise
	 */
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

	/**
	 * Receives a single group to evaluate within a String. If the group is not a
	 * valid number, return 0
	 * 
	 * @param stringToCalculate The String with a numeric value to evaluate it.
	 * @return The numeric value of the received String, 0 otherwise
	 */
	protected int singleGroupValue(String stringToCalculate) {
		String trimmedString = stringToCalculate.trim();
		try {
			return Integer.parseInt(trimmedString);
		} catch (NumberFormatException e) {
			// Valid scenario, if the group is not a number, give a numeric value of 0
		}
		return 0;
	}

}
