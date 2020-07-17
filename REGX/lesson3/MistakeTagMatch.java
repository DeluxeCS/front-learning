package net.itcast.course.regex.basic.lesson3;

public class MistakeTagMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strings = new String[] { "<h1>good</h1>", "<h1>bad</h2>"};
		
		String regex = "<\\w+>[^<]+</\\w+>";
		
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
