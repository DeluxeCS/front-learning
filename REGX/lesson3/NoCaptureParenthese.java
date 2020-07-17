package net.itcast.course.regex.basic.lesson3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoCaptureParenthese {

	public static void main(String[] args) {
		String email = "webmaster@itcast.net";

		String regex = "(?:webmaster|admin)@(itcast.net)";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(email);

		if (m.find()) {
			System.out.println("match result:\t" + m.group(0));
			System.out.println("group No.1 is:\t" + m.group(1));
		}

	}
}
