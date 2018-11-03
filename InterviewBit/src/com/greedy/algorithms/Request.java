package com.greedy.algorithms;

public class Request {

	int startTime;
	int endTime;
	int deadLine;
	String name;

	Request(int startTime, int endTime, String name) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;

	}

	public int getDuration() {

		return endTime - startTime;
	}

}
