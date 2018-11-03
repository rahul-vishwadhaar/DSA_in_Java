/**
 * 
 */
package com.test;

import java.math.BigDecimal;

/**
 * @author rahul
 *
 */
public class Test_1 {

	/**
	 * @param args
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Double number1 = 0.75;
		
		Double number5 = 0.035;
		
		BigDecimal bd1 = new BigDecimal(String.valueOf(number1));
		
		BigDecimal bd2 = new BigDecimal(String.valueOf(number5));
		
		System.out.println(bd1.add(bd2));
		

		System.out.println(number1 +  number5);
	}

}
