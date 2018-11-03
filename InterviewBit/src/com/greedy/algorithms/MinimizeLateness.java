/**
 * 
 */
package com.greedy.algorithms;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MinimizeLateness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minimizeDelay(ArrayList<Request> requestList) {

		int delay = 0;
		int finishingTime = 0;
		requestList = sortByDeadLine(requestList);

		for (Request req : requestList) {

			finishingTime = req.getDuration();

			if (req.deadLine < finishingTime) {
				delay = finishingTime - req.deadLine;
			}
		}

		return delay;
	}

	private static ArrayList<Request> sortByDeadLine(ArrayList<Request> requestList) {
		ArrayList<Request> sortedList = new ArrayList<Request>();

		for (Request req : requestList) {
			insert(sortedList, req);
		}

		return sortedList;
	}

	private static void insert(ArrayList<Request> sortedList, Request req) {

		int index = 0;
		for (index = 0; index < sortedList.size(); index++) {

			if (req.deadLine > sortedList.get(index).deadLine) {
				break;
			}
		}

		sortedList.add(index, req);

	}

}
