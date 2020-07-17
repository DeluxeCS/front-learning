package net.itcast.course.regex.basic.lesson2;

public class CharacterClassBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] octDigits = new String[] { "0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9" };
		String[] hexDigits = new String[] { "0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "a", "b", "c", "d", "e", "f" };

		String octDigitRegex = "[0123456789]";

		String hexDigitRegex = "[0123456789abcdef]";

		for (String octDigit : octDigits) {
			if (regexMatch(octDigit, octDigitRegex)) {
				System.out.println("\"" + octDigit
						+ "\" can be matched with regex \"" + octDigitRegex
						+ "\"");
			} else {
				System.out.println("\"" + octDigit
						+ "\" can not be matched with regex \"" + octDigitRegex
						+ "\"");
			}
		}

		for (String hexDigit : hexDigits) {
			if (regexMatch(hexDigit, hexDigitRegex)) {
				System.out.println("\"" + hexDigit
						+ "\" can be matched with regex \"" + hexDigitRegex
						+ "\"");
			} else {
				System.out.println("\"" + hexDigit
						+ "\" can not be matched with regex \"" + hexDigitRegex
						+ "\"");
			}
		}

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
