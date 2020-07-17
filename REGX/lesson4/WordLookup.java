package net.itcast.course.regex.basic.lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordLookup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "This sentence contains word 'cat'";

		String regex = "\\scat\\s";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);

		if (m.find()) {
			System.out.println("Found word \"cat\"!");
		} else {
			System.out.println("Can not found word \"cat\"!");
		}

	}

}
