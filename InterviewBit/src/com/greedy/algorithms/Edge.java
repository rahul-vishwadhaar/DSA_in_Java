package com.greedy.algorithms;

public class Edge {

	private int cost;
	private Vertex startNode;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Vertex getStartNode() {
		return startNode;
	}

	public void setStartNode(Vertex startNode) {
		this.startNode = startNode;
	}

	public Vertex getEndNode() {
		return endNode;
	}

	public void setEndNode(Vertex endNode) {
		this.endNode = endNode;
	}

	private Vertex endNode;

}
