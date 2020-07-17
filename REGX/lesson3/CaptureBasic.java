package net.itcast.course.regex.basic.lesson3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureBasic {

	public static void main(String[] args) {
		String email = "webmaster@itcast.net";

		String regex = "(\\w+)@([\\w.]+)";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(email);

		if (m.find()) {
			System.out.println("email add is:\t" + m.group(0));
			System.out.println("username is:\t" + m.group(1));
			System.out.println("hostname is:\t" + m.group(2));
		}

	}

}
