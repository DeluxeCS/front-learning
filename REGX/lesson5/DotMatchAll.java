package net.itcast.course.regex.basic.lesson5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotMatchAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "<a href=www.itcast.net>\nITCAST\n</a>";
		
		String regex = "<a href=([^>]+)>.*</a>";
		
		Pattern p = Pattern.compile(regex);//
		
		Matcher m = p.matcher(str);
		
		if(m.find()) {		
			System.out.println("\"" + str
					+ "\" can be matched with regex \"" + regex
					+ "\"");
		} else {
			System.out.println("\"" + str
					+ "\" can not be matched with regex \"" + regex
					+ "\"");
		}

	}

}
