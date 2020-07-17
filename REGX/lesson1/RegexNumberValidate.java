package net.itcast.course.regex.basic.lesson1;

public class RegexNumberValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] values = new String[] {"10", "32768", "99999", "ati", "90AF", "ffff"};
		
		for (String value : values) {
			
			System.out.println("Validating value:\t" + value);
			
			if(isOctNumber(value)) {
				System.out.println("[" + value + "] is valid Oct number");
			}
			
			if(isHexNumber(value)) {
				System.out.println("[" + value + "] is valid Hex number");
			}
			
			System.out.println("");
		}

	}
	
	public static boolean isOctNumber(String s) {
		String validateRegex = Regexes.OCT_NUM_REGEX;
		return s.matches(validateRegex);
	}
	
	public static boolean isHexNumber(String s) {
		String validateRegex = Regexes.HEX_NUM_REGEX;
		return s.matches(validateRegex);
	}

}
