package net.itcast.course.regex.basic.lesson2;

public class CharacterClassShorthand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String digitChar = "\\d";
		String noDigitChar = "\\D";
		String wordChar = "\\w";
		String noWordChar = "\\W";
		String spaceChar = "\\s";
		String noSpaceShar = "\\S";

		String[] strs = new String[] { "0", "3", "8", "9", "a", "z", "E", "G",
				" ", "\t", "\r" };

		for (String s : strs) {
			if (regexMatch(s, digitChar)) {
				System.out.println("\"" + digitChar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + digitChar + "\" can not match \"" + s
						+ "\"");
			}
		}
		System.out.println("");

		for (String s : strs) {
			if (regexMatch(s, noDigitChar)) {
				System.out.println("\"" + noDigitChar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + noDigitChar + "\" can not match \""
						+ s + "\"");
			}
		}
		System.out.println("");

		for (String s : strs) {

			if (regexMatch(s, wordChar)) {
				System.out.println("\"" + wordChar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + wordChar + "\" can not match \"" + s
						+ "\"");
			}
		}
		System.out.println("");

		for (String s : strs) {
			if (regexMatch(s, noWordChar)) {
				System.out.println("\"" + noWordChar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + noWordChar + "\" can not match \""
						+ s + "\"");
			}
		}
		System.out.println("");

		for (String s : strs) {
			if (regexMatch(s, spaceChar)) {
				System.out.println("\"" + spaceChar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + spaceChar + "\" can not match \"" + s
						+ "\"");
			}
		}
		
		System.out.println("");

		for (String s : strs) {
			if (regexMatch(s, noSpaceShar)) {
				System.out.println("\"" + noSpaceShar + "\" can match \"" + s
						+ "\"");
			} else {
				System.out.println("\"" + noSpaceShar + "\" can not match \""
						+ s + "\"");
			}
		}

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
