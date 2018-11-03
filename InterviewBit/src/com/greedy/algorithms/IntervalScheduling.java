/**
 * 
 */
package com.greedy.algorithms;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class IntervalScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Request> requestList = new ArrayList<Request>();

		requestList.add(new Request(0, 10, "6"));
		requestList.add(new Request(0, 1, "1"));
		requestList.add(new Request(0, 3, "2"));
		requestList.add(new Request(2, 5, "3"));
		requestList.add(new Request(4, 6, "4"));
		requestList.add(new Request(7, 9, "5"));
		requestList.add(new Request(0, 10, "6"));
		requestList.add(new Request(8, 11, "7"));
		requestList.add(new Request(8, 14, "8"));
		requestList.add(new Request(12, 15, "9"));

		requestList = schedule(requestList);

		for (Request req : requestList) {

			System.out.println(req.name);
		}

	}

	public static ArrayList<Request> schedule(ArrayList<Request> requests) {
		ArrayList<Request> schedule = new ArrayList<Request>();

		Request req = null;

		while (!requests.isEmpty()) {

			req = getSmallestFinishingTime(requests);
			requests = removeOverlappingReqests(requests, req);
			schedule.add(req);

		}

		return schedule;

	}

	private static ArrayList<Request> removeOverlappingReqests(ArrayList<Request> requests, Request req) {
		ArrayList<Request> updatedRequestList = new ArrayList<Request>();

		for (Request request : requests) {

			if (!overlapping(request, req)) {
				updatedRequestList.add(request);
			}

		}
		return updatedRequestList;
	}

	private static boolean overlapping(Request request, Request req) {

		if ((request.startTime <= req.endTime) && (req.endTime <= request.endTime))
			return true;

		if ((request.startTime <= req.startTime) && (request.endTime >= req.startTime))
			return true;

		if ((req.startTime > request.startTime) && (req.endTime < request.endTime))
			return true;

		return false;

	}

	private static Request getSmallestFinishingTime(ArrayList<Request> requestList) {
		Request minRequest = null;

		if (requestList.isEmpty())
			return null;

		minRequest = requestList.get(0);

		for (Request req : requestList) {

			if (req.endTime < minRequest.endTime)
				minRequest = req;

		}
		return minRequest;
	}

}
