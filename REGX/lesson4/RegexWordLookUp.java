package net.itcast.course.regex.basic.lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWordLookUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strings = new String[] {
				"This sentence contain word cat",
				"This sentence contain word \"cat\"",
				"This sentence contain word vacation",
				"This sentence contain word \"cate\"",
		};
		
		String regex = "\\bcat\\b";
		
		for(String str : strings) {
			System.out.println("Checking sentence:\t" + str);
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			
			if(m.find()) {
				System.out.println("Found word \"cat\"!");
			}
			else {
				System.out.println("Can not found word \"cat\"!");
			}
			
			System.out.println("");
			
		}

	}

}
