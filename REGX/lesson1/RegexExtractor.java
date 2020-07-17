package net.itcast.course.regex.basic.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtractor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String htmlCode = "<html>\n" +
		"<a href=\"www.itcast.net\">ITCast</a>\n" +
		"<a href='http://www.itcast.net/portal/teachers'>ITCast</a>\n" +
		"<a href=http://www.itcast.net/portal>ITCast</a>\n" +
		"<a href  = http://www.itcast.net/portal/courses/>ITCast</a>\n" +
		"<a href	=\"http://www.itcast.net/help\">ITCast</a>\n" +
		"student@itcast.net\n" +
		"webmaster@itcast.net\n" +
		"teachers@itcast.net\n"
		+ "</html>";
		
		System.out.println("Checking email");
		for(String email:extractEmail(htmlCode)) {
			System.out.println("Email:\t" + email);
		}
		System.out.println("");

		System.out.println("Checking link");
		for(String link:extractLink(htmlCode)) {
			System.out.println("Link:\t" + link);
		}
		System.out.println("");
	}

	public static List<String> extractEmail(String s) {

		List<String> result = new ArrayList<String>();

		Pattern p = Pattern.compile(Regexes.EMAIL_REGEX);
		Matcher m = p.matcher(s);

		while (m.find()) {
			result.add(m.group());
		}

		return result;
	}

	public static List<String> extractLink(String s) {
		List<String> result = new ArrayList<String>();

		Pattern p = Pattern.compile(Regexes.HREF_LINK_REGEX);
		Matcher m = p.matcher(s);

		while (m.find()) {
			result.add(m.group(1));
		}

		return result;
	}

}
