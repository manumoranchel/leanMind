package leanMind.katas;

public class StringCalculator {
	
	private static final String SEPARATOR = ",";

	protected int calculateString(String stringToCalculate) {
		
		int sum = 0;
		for (String currentGroup : stringToCalculate.split(SEPARATOR)) {
			sum += singleGroupValue(currentGroup); 
		}
		return sum;
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
