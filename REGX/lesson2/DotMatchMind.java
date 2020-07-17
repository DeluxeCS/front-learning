package net.itcast.course.regex.basic.lesson2;

public class DotMatchMind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dot = ".";
		
		String lineFeed = "\n";
		
		if(regexMatch(lineFeed, dot)) {
			System.out.println("Dot can match LineFeed");
		}
		else {
			System.out.println("Dot can not match LineFeed");
		}
		

	}
	
	public static boolean regexMatch(String s, String regex) {
		return s.matches(regex);
	}

}
