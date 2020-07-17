package net.itcast.course.regex.basic.lesson1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDupWordFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sentences = new String[] { "This is a normal sentence",
				"I carelessly typed duplicate word word",
				"This sentence contain no duplicate word words", };

		for (String sentence : sentences) {
			System.out.println("Sentence is:\t" + sentence);
			if (containDupWord(sentence)) {
				System.out.println("Duplicate word found!");
				System.out.println("After processing:"
						+ removeDupWords(sentence));
			}
			System.out.println("");
		}

	}

	public static boolean containDupWord(String s) {
		String regex = Regexes.DUP_WORD_REGEX;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static String removeDupWords(String s) {
		String regex = Regexes.DUP_WORD_REGEX;
		return s.replaceAll(regex, "$1");
	}

}
