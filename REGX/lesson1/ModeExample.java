package net.itcast.course.regex.basic.lesson1;

public class ModeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String emailRegex = Regexes.USERNAME_REGEX + "@"
				+ Regexes.HOSTNAME_REGEX;

		String email = "webmaster@itcast.net";

		if (email.matches(emailRegex)) {
			System.out.println("\"" + email + "\" can be matched");
		}

		else {
			System.out.println("\"" + email + "\" can not  be matched");
		}

	}

}
