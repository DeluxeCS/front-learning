package net.itcast.course.regex.basic.lesson3;

public class IntervalBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strings = new String[] { "", "a", "aa", "aaa", "aaaa", "aaaaa" };

		String regex = "a{2,4}";
		String regex2 = "a{2,}";
		String regex3 = "a{3}";

		for (String str : strings) {
			if (str.matches(regex)) {
				System.out.println("\"" + str
						+ "\" can be matched with regex \"" + regex + "\"");
			} else {
				System.out.println("\"" + str
						+ "\" can not be matched with regex \"" + regex + "\"");
			}
		}

		System.out.println("");

		for (String str : strings) {
			if (str.matches(regex2)) {
				System.out.println("\"" + str
						+ "\" can be matched with regex \"" + regex2 + "\"");
			} else {
				System.out
						.println("\"" + str
								+ "\" can not be matched with regex \""
								+ regex2 + "\"");
			}
		}

		System.out.println("");

		for (String str : strings) {
			if (str.matches(regex3)) {
				System.out.println("\"" + str
						+ "\" can be matched with regex \"" + regex3 + "\"");
			} else {
				System.out
						.println("\"" + str
								+ "\" can not be matched with regex \""
								+ regex3 + "\"");
			}
		}

	}

}
