package net.itcast.course.regex.basic.lesson5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MixedModeSpan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "<A Href=www.itcast.net>\nITCAST\n</A>";

		String regex = "(?is)<a href=([^>]+)>.*</a>";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str);

		if (m.find()) {
			System.out.println("\"" + str + "\" can be matched with regex \""
					+ regex + "\"");
		} else {
			System.out.println("\"" + str
					+ "\" can not be matched with regex \"" + regex + "\"");
		}

	}

}
