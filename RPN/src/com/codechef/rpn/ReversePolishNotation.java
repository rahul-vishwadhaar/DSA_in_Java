/**
 * 
 */
package com.codechef.rpn;

import java.util.Scanner;

/**
 * @author rahul kumar
 * 
 */
public class ReversePolishNotation {

	/**
	 * @param args
	 */

	private static int top = -1;
	private static final int STACK_MAX_CAPACITY = 10000;
	private static char[] arr_stack = new char[STACK_MAX_CAPACITY];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int noOfCases = in.nextInt();

		while (noOfCases-- > 0) {

			String input = in.next();
			System.out.println(noOfCases + " " + input);
			int len = 0;

			while (len < input.length()) {
				char ch = input.charAt(len);

				switch (ch) {
				case '(':
				case '+':
				case '-':
				case '*':
				case '/':
				case '^':
					push(ch);
					break;
				case ')':
					System.out.print(pop());
					pop();
					break;
				default:
					System.out.print(ch);
				}
				len++;
			}
		}
		in.close();
	}

	public static char pop() {
		if (top == -1)
			return '.';
		else {
			top--;
			return arr_stack[top + 1];
		}
	}

	public static void push(char ch) {
		if (top < STACK_MAX_CAPACITY - 1) {
			top++;
			arr_stack[top] = ch;
		} else {
			System.out.println("Stack full");
		}
	}
}
