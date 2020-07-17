package net.itcast.course.regex.basic.lesson1;

public class FormalExpressShow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String regex1 = "\\d+";
		
		String str1 = "0123456";
		
		if(str1.matches(regex1)) {
			System.out.println("\"" + str1 + "\" can be matched with regex \"" + regex1 + "\"");
		}
		
		String regex2 = "sep[ea]r[ea]te";
		
		String str2 = "seperate";
		
		if(str2.matches(regex2)) {
			System.out.println("\"" + str2 + "\" can be matched with regex \"" + regex2 + "\"");
		}
		

	}

}
