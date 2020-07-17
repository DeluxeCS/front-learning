package net.itcast.course.regex.basic.lesson2;

public class NegativeCharacterClassBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] hexDigits = new String[] { "0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "a", "b", "c", "d", "e", "f" };

		String negativeDigitRegex = "[^0-5]";

		String negativeDigitRegex2 = "[^0-5e-f]";

		for (String hexDigit : hexDigits) {
			if (regexMatch(hexDigit, negativeDigitRegex)) {
				System.out.println("\"" + hexDigit
						+ "\" can be matched with regex \"" + negativeDigitRegex
						+ "\"");
			} else {
				System.out.println("\"" + hexDigit
						+ "\" can not be matched with regex \"" + negativeDigitRegex
						+ "\"");
			}
		}

		for (String hexDigit : hexDigits) {
			if (regexMatch(hexDigit, negativeDigitRegex2)) {
				System.out.println("\"" + hexDigit
						+ "\" can be matched with regex \"" + negativeDigitRegex2
						+ "\"");
			} else {
				System.out.println("\"" + hexDigit
						+ "\" can not be matched with regex \"" + negativeDigitRegex2
						+ "\"");
			}
		}

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
