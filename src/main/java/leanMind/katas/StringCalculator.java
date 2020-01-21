package leanMind.katas;

public class StringCalculator {
	
	protected int calculateString(String stringToCalculate) {
		return singleGroupValue(stringToCalculate);
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
