package net.itcast.course.regex.basic.lesson2;

public class NegativeCharacterClassMind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[] { "case", "casa", "caso", "cas" };

		String regex = "cas[^e]";

		for (String s : strings) {
			if (regexMatch(s, regex)) {
				System.out.println("\"" + s + "\" can be matched with regex \""
						+ regex + "\"");
			} else {
				System.out.println("\"" + s
						+ "\" can not be matched with regex \"" + regex + "\"");
			}
		}

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
