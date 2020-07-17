package net.itcast.course.regex.basic.lesson3;

public class AlternationBasic {

	public static void main(String[] args) {
		
		
		String[] strings = new String[] { "this", "that", "thit"};
		
		String regex = "(this|that)";
		
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
		
	}

}
