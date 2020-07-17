package net.itcast.course.regex.basic.lesson2;

public class CharacterClassWithDashBegin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] characters = new String[] { "a", "b", "c", "d", "e", "f", "g",
				"-" };

		String regex1 = "[a-g]";

		String regex2 = "[-ag]";

		for (String character : characters) {
			if (regexMatch(character, regex1)) {
				System.out.println("\"" + character
						+ "\" can be matched with regex \"" + regex1 + "\"");
			} else {
				System.out
						.println("\"" + character
								+ "\" can not be matched with regex \""
								+ regex1 + "\"");
			}
		}

		System.out.println("");

		for (String character : characters) {
			if (regexMatch(character, regex2)) {
				System.out.println("\"" + character
						+ "\" can be matched with regex \"" + regex2 + "\"");
			} else {
				System.out
						.println("\"" + character
								+ "\" can not be matched with regex \""
								+ regex2 + "\"");
			}
		}

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
