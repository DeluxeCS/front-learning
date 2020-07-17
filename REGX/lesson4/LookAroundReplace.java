package net.itcast.course.regex.basic.lesson4;

public class LookAroundReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] numbers = new String[] {
				"123456", "1234567890"
		};
		
		String regex = "(?<=\\d)(?=(\\d{3})+(?!\\d))";
		
		for(String number : numbers) {
			System.out.println("Before processing:\t" + number);
			System.out.println("After processing:\t" + number.replaceAll(regex, ","));
		}

	}

}
