/**
 * 
 */
package com.stackAndQueues;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class EvaluateExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String strs =" 2, 2, /";

		ArrayList<String> a =  new ArrayList<String>();
		a.add(strs);
		System.out.println(evalRPN(a));

	}

	public static int evalRPN(ArrayList<String> a) {

		int num1 = 0;
		int num2 = 0;
		int index = 0;
		ArrayList<Integer> stack = new ArrayList<Integer>();

		
		while(index < a.size()){
			
			num1 =0;
			num2 = 0;
			stack.clear();
		
		try {

			for (int i = 0; i < a.get(index).length(); i++) {

				try {

					int current = Integer.parseInt((a.get(index).substring(i,i)));

					stack.add(0, current);

				} catch (Exception e) {

					String operation = a.get(i);
					num1 = stack.remove(0);
					num2 = stack.remove(0);

					if (operation == "+") {

						stack.add(0, num2 + num1);
					} else if (operation == "-") {
						stack.add(0, num2 - num1);
					} else if (operation == "*") {
						stack.add(0, num2 * num1);
					} else if (operation == "/") {
						stack.add(0, num2 / num1);
					} else {
						throw new Exception("Invalid expression");
					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(stack.get(0));
	}
		return 0;
}
	
	
}
