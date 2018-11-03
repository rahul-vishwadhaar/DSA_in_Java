package com.codechef.threewaycom;

import java.util.Scanner;

public class ThreeWayCommunication {

	public static void main(String[] args) {

		int noOfTestCases = -1;
		double maxDistance = 0;
		int posX = -1;
		int posY = -1;

		Scanner in = new Scanner(System.in);

		noOfTestCases = in.nextInt();

		while (noOfTestCases > 0) {
			maxDistance = in.nextDouble();
			posX = in.nextInt();
			posY = in.nextInt();
			Location positionChef = new Location(posX, posY);

			posX = in.nextInt();
			posY = in.nextInt();
			Location positionHeadServer = new Location(posX, posY);

			posX = in.nextInt();
			posY = in.nextInt();
			Location positionSousChef = new Location(posX, posY);

			boolean result = calculateDistanceANDReturnResult(maxDistance, positionChef,
					positionHeadServer, positionSousChef);

			if (result)
				System.out.println("yes");
			else
				System.out.println("no");
			noOfTestCases--;
		}
		in.close();
	}

	private static boolean calculateDistanceANDReturnResult(double maxDistance,
			Location positionChef, Location positionHeadServer,
			Location positionSousChef) {

		double dist1 = getDistance(positionChef, positionHeadServer);
		double dist2 = getDistance(positionHeadServer, positionSousChef);
		double dist3 = getDistance(positionChef, positionSousChef);

		if (((dist1 <= maxDistance) && (dist2 <= maxDistance))
				|| ((dist3 <= maxDistance) && (dist2 <= maxDistance))
				|| ((dist1 <= maxDistance) && (dist3 <= maxDistance)))
			return true;
		else
			return false;

	}

	private static double getDistance(Location positionA, Location positionB) {
		return Math.sqrt(Math.pow(
				(double) (positionA.pointX - positionB.pointX), 2)
				+ Math.pow((double) (positionA.pointY - positionB.pointY), 2));

	}

	static class Location {
		private int pointX = 0;
		private int pointY = 0;

		Location(int x, int y) {
			this.pointX = x;
			this.pointY = y;
		}
	}

}
