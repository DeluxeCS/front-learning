package net.itcast.course.regex.basic.lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnchorBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strings = new String[] { "start ", " start  ", " end ", " end" };

		String[] regexes = new String[] { "^start", "\\Astart", "end$", "end\\Z"};

		for (String str : strings) {
			for (String regex : regexes) {
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				if(m.find()) {
					System.out.println("\"" + str
							+ "\" can be matched with regex \"" + regex
							+ "\"");
				}
				else {
					System.out.println("\"" + str
							+ "\" can not be matched with regex \"" + regex
							+ "\"");
				}
			}
			System.out.println("");
		}

	}
}
