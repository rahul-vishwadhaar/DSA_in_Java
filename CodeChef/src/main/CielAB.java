package main;

import java.util.Scanner;

public class CielAB{
 
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = -1;
		int num1 = 0;
		int num2 = 0;
		int diff = 0;
		noOfTestCases = in.nextInt();
		
		while(noOfTestCases > 0)
		{
			num1 = in.nextInt();
			num2 = in.nextInt();
			
			diff = num1 - num2;
			
			if(diff % 10 == 9)
				diff--;
			else
				diff++;
				
		     System.out.println(diff);	
		     
		     noOfTestCases --;	
		}
		in.close();
		
	}	
} 