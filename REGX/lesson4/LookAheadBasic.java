package net.itcast.course.regex.basic.lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAheadBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strings = new String[] { "Jeff", "Jeffrey", "Jefferson"};

		String[] regexes = new String[] { "Jeff", "Jeff(?=rey)", "Jeff(?!rey)"};

		for (String regex : regexes) {
			for (String str : strings) {
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
