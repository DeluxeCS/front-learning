package net.itcast.course.regex.basic.lesson2;

public class CharacterMixUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mixedRegex = "[\\da-f]";
		
		String[] strs = new String[] {
				"0", "1", "2", "3", "4", "9", "a", "e", "f", "g", "j", "z"
		};
		
		for(String str : strs) {
			if(regexMatch(str, mixedRegex)) {
				System.out.println("\"" + mixedRegex + "\" can match \"" + str + "\"");
			} else {
				System.out.println("\"" + mixedRegex + "\" can not match \"" + str + "\"");
			}
		}

	}
	
	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
