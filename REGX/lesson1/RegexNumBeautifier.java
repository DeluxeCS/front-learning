package net.itcast.course.regex.basic.lesson1;

public class RegexNumBeautifier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] numbers = new String[] { "1234567890", "123456", "123" };

		for (String number : numbers) {
			System.out.println(number + "\n" + beautifyNumber(number) + "\n");
		}

	}
	
	
	
	
	
	
	
	
	

	public static String beautifyNumber(String s) {
		return s.replaceAll(Regexes.NUMBER_BEAUTIFY_REGEX, ",");
	}

}
