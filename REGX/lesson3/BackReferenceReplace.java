package net.itcast.course.regex.basic.lesson3;

public class BackReferenceReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dupWords = "word word";
		
		String dupWordRegex = "(\\w+)\\s+(\\1)";
		
		System.out.println("Before replace:\t" + dupWords);
		System.out.println("After replace:\t" + dupWords.replaceAll(dupWordRegex, "$1"));

	}

}
