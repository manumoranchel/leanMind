package leanMind.katas;

public class StringCalculator {
	
	protected int calculateString(String stringToCalculate) {
		return singleGroupValue(stringToCalculate);
	}

	protected int singleGroupValue(String stringToCalculate) {
		try {
			return Integer.parseInt(stringToCalculate);
		} catch (NumberFormatException e) {
			System.out.println("Found a non numeric value");
		}
		return 0;
	}

}
