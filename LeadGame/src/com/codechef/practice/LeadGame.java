package com.codechef.practice;

import java.util.Scanner;

public class LeadGame {

	public static void main(String args[]) {
		int count = 0;
		int scoreA = 0;
		int scoreB = 0;
		int winner = 0;
		int lead = 0;
		int diff = -1;
		int leader = -1;
		Scanner in = new Scanner(System.in);
		count = in.nextInt();

		while (count > 0) {
			scoreA = in.nextInt();
			scoreB = in.nextInt();

			if ((scoreA - scoreB) > 0) {
				diff = scoreA - scoreB;
				leader = 1;
			} else {
				diff = scoreB - scoreA;
				leader = 2;
			}
			if (diff > lead) {
				lead = diff;
				winner = leader;
			}
			count--;
		}
		
		System.out.print(winner + " ");
		System.out.print(lead);
		in.close();
	}

}
