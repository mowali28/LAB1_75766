package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number = "0";  // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	}

	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		// initial variable
		int carry = 0;
		String num3 = "";  // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2;  // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
		}
		Binary result = new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}

	/**
	 * Bitwise logical OR operation.
	 *
	 * @param b1 The first binary object.
	 * @param b2 The second binary object.
	 * @return A binary object representing the OR operation of the two inputs.
	 */
	public static Binary OR(Binary b1, Binary b2) {
		StringBuilder result = new StringBuilder();
		int maxLength = Math.max(b1.number.length(), b2.number.length());
		String v1 = String.format("%" + maxLength + "s", b1.number).replace(' ', '0');
		String v2 = String.format("%" + maxLength + "s", b2.number).replace(' ', '0');

		for (int i = 0; i < maxLength; i++) {
			result.append((v1.charAt(i) == '1' || v2.charAt(i) == '1') ? '1' : '0');
		}
		return new Binary(result.toString());
	}

	/**
	 * Bitwise logical AND operation.
	 *
	 * @param b1 The first binary object.
	 * @param b2 The second binary object.
	 * @return A binary object representing the AND operation of the two inputs.
	 */
	public static Binary AND(Binary b1, Binary b2) {
		StringBuilder result = new StringBuilder();
		int maxLength = Math.max(b1.number.length(), b2.number.length());
		String v1 = String.format("%" + maxLength + "s", b1.number).replace(' ', '0');
		String v2 = String.format("%" + maxLength + "s", b2.number).replace(' ', '0');

		for (int i = 0; i < maxLength; i++) {
			result.append((v1.charAt(i) == '1' && v2.charAt(i) == '1') ? '1' : '0');
		}
		return new Binary(result.toString());
	}

	/**
	 * Multiply two binary variables.
	 *
	 * @param b1 The first binary object.
	 * @param b2 The second binary object.
	 * @return A binary object representing the product of the two inputs.
	 */
	public static Binary Multiply(Binary b1, Binary b2) {
		int num1 = Integer.parseInt(b1.number, 2);
		int num2 = Integer.parseInt(b2.number, 2);
		int product = num1 * num2;
		return new Binary(Integer.toBinaryString(product));
	}
}
