package net.itcast.course.regex.basic.lesson3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureMind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		explainGroupNo();
		
		System.out.println("");
		
		explainGroupQuantifier();		

	}
	
	public static void explainGroupNo() {
		String email = "webmaster@itcast.net";

		String regex = "((\\w+)@([\\w.]+))";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(email);

		if (m.find()) {
			System.out.println("match result:\t" + m.group(0));
			System.out.println("group No.1 is:\t" + m.group(1));
			System.out.println("group No.2 is:\t" + m.group(2));
			System.out.println("group No.3 is:\t" + m.group(3));
		}
	}
	
	public static void explainGroupQuantifier() {
		String email = "webmaster@itcast.net";

		String regex = "(\\w)+@([\\w.])+";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(email);

		if (m.find()) {
			System.out.println("match result:\t" + m.group(0));
			System.out.println("group No.1 is:\t" + m.group(1));
			System.out.println("group No.2 is:\t" + m.group(2));
		}
	}

}
