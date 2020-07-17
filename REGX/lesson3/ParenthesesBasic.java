package net.itcast.course.regex.basic.lesson3;

public class ParenthesesBasic {

	public static void main(String[] args) {
		String[] strings = new String[] { "ac", "acc", "accc", "acac", "acacac"};
		
		String regex = "ac+";
		String regex2 = "(ac)+";
		
		for (String str : strings) {
			if (str.matches(regex)) {
				System.out.println("\"" + str
						+ "\" can be matched with regex \"" + regex
						+ "\"");
			} else {
				System.out.println("\"" + str
						+ "\" can not be matched with regex \"" + regex
						+ "\"");
			}
		}
		
		System.out.println("");
		
		for (String str : strings) {
			if (str.matches(regex2)) {
				System.out.println("\"" + str
						+ "\" can be matched with regex \"" + regex2
						+ "\"");
			} else {
				System.out.println("\"" + str
						+ "\" can not be matched with regex \"" + regex2
						+ "\"");
			}
		}
		
	}

}
