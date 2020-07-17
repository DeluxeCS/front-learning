package net.itcast.course.regex.basic.lesson1;

public class Regexes {
	
	
	public static final String OCT_NUM_REGEX = "\\d+";
	
	public static final String HEX_NUM_REGEX = "(?i)[0-9a-f]+";
	
	public static final String DUP_WORD_REGEX = "(?<=\\b)(\\w+)\\s+\\1(?=\\b)";
	
	public static final String EMAIL_REGEX = "(?i)(?<=\\b)[a-z0-9][-a-z0-9_.]+[a-z0-9]@([a-z0-9][-a-z0-9]+\\.)+[a-z]{2,4}(?=\\b)";
	
	public static final String HREF_LINK_REGEX = "(?i)<a\\s+href\\s*=\\s*['\"]?([^'\"\\s>]+)['\"\\s>]";
	
	public static final String NUMBER_BEAUTIFY_REGEX = "(?<=\\d)(?=((\\d{3})+\\b))";
	
	public static final String USERNAME_REGEX = "(?<=\\b)[a-z0-9][-a-z0-9_.]+[a-z0-9]";
	
	public static final String HOSTNAME_REGEX = "([a-z0-9][-a-z0-9]+\\.)+[a-z]{2,4}(?=\\b)";

}
