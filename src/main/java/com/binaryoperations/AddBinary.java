package com.binaryoperations;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100" Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 * 
 * @author abhin
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		StringBuilder sb = new StringBuilder();

		int carry = 0;

		int i = a.length() - 1, j = b.length() - 1;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0) {
				sum = sum + a.charAt(i) - '0';
			}

			if (j >= 0) {
				sum = sum + b.charAt(j) - '0';
			}

			// sum can be 0, 1, 2 or 3. For even its 0 and odd its 1
			sb.append(sum % 2);

			// carry can either be 0 or 1
			carry = sum > 1 ? 1 : 0;
			i--;
			j--;
		}

		if (carry > 0) {
			sb.append('1');
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {

		AddBinary obj = new AddBinary();

		System.out.println(obj.addBinary("1010", "1011"));
	}

}
