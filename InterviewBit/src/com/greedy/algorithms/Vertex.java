package com.greedy.algorithms;

import java.util.HashSet;

public class Vertex {

	int value;

	private HashSet<Edge> edges;

	Vertex(int value) {
		this.value = value;
		edges = new HashSet<Edge>();
	}

	public HashSet<Edge> getEdges() {
		return edges;
	}

	public void setEdges(HashSet<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public void removeEdge(Edge edge) {

		edges.remove(edge);
	}

}
