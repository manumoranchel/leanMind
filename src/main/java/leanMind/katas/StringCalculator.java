package leanMind.katas;

public class StringCalculator {
	
	private static final String DEFAULT_SEPARATOR = ",";
	private static final String EMBEDDED_SEPARATOR_BEGIN = "//";
	private static final String EMBEDDED_SEPARATOR_END = ";";
	
	protected int calculateString(String stringToCalculate) {
		
		int sum = 0;
		String separator = fetchSeparator(stringToCalculate);
		for (String currentGroup : stringToCalculate.split(separator)) {
			sum += singleGroupValue(currentGroup); 
		}
		return sum;
	}

	protected String fetchSeparator(String stringToCalculate) {
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
