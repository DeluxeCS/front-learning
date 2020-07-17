package net.itcast.course.regex.basic.lesson1;

public class RegexEmailValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = new String[] { "webmaster@itcast.net",
				"web.master@itcast.net", "webmaster@it-cast.net",
				".webmaster@itcast.net", "webmaster@itcast",
				"webmaster.itcast." };

		for (String email : emails) {

			System.out.println("Validating:\t" + email);

			if (isValideEmail(email)) {
				System.out.println("[" + email + "] is valid email");
			}

			System.out.println("");
		}

	}

	private static boolean isValideEmail(String s) {
		return s.matches(Regexes.EMAIL_REGEX);
	}

}
