package net.itcast.course.regex.basic.lesson2;

public class DotMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[] { "a", "A", "0", "$", "(", "."};

		String normalDot = ".";
		String escapedDot = "\\.";
		String characterClassDot = "[.]";

		for (String s : strings) {
			if (regexMatch(s, normalDot)) {
				System.out.println("\"" + s + "\" can be matched with regex \""
						+ normalDot + "\"");
			} else {
				System.out.println("\"" + s
						+ "\" can not be matched with regex \"" + normalDot + "\"");
			}
		}
		
		System.out.println("");
		
		for (String s : strings) {
			if (regexMatch(s, escapedDot)) {
				System.out.println("\"" + s + "\" can be matched with regex \""
						+ escapedDot + "\"");
			} else {
				System.out.println("\"" + s
						+ "\" can not be matched with regex \"" + escapedDot + "\"");
			}
		}
		
		System.out.println("");
		
		for (String s : strings) {
			if (regexMatch(s, characterClassDot)) {
				System.out.println("\"" + s + "\" can be matched with regex \""
						+ characterClassDot + "\"");
			} else {
				System.out.println("\"" + s
						+ "\" can not be matched with regex \"" + characterClassDot + "\"");
			}
		}
		
		System.out.println("");

	}

	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
