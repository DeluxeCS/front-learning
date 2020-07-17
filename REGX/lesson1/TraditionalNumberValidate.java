package net.itcast.course.regex.basic.lesson1;

public class TraditionalNumberValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] values = new String[] { "10", "32768", "99999", "ati", "90AF",
				"ffff" };

		for (String value : values) {

			System.out.println("Validating value:\t" + value);

			if (isOctNumber(value)) {
				System.out.println("[" + value + "] is valid Oct number");
			}

			if (isHexNumber(value)) {
				System.out.println("[" + value + "] is valid Hex number");
			}

			System.out.println("");
		}

	}

	public static boolean isOctNumber(String s) {
		boolean result = true;
		for (int i = 0, n = s.length(); i < n; i++) {
			char c = s.charAt(i);
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
					|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
				continue;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static boolean isHexNumber(String s) {
		boolean result = true;
		for (int i = 0, n = s.length(); i < n; i++) {
			char c = s.charAt(i);
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
					|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
					|| c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e'
					|| c == 'f' || c == 'A' || c == 'B' || c == 'C' || c == 'D'
					|| c == 'E' || c == 'F') {
				continue;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

}
