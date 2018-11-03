package com.coursera.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix extends Graph {

	private int[][] adjMatrix;

	// Returns Immediate neighbours
	public List<Integer> getNeighbours(int v) {

		List<Integer> neighbours = new ArrayList<Integer>();

		for (int i = 0; i < getNumVertices(); i++) {
			for (int j = 0; j < adjMatrix[v][i]; j++) { // multiple edges
														// between two nodes
				neighbours.add(i);
			}

			return neighbours;
		}
	}

	public List<Integer> getTwoHopNeighbours(int v) {

		List<Integer> twoHopNeighbours = new ArrayList<Integer>();

		int adjMatrixSquared[][]; // adjMatrix * adjMatrix

		for (int i = 0; i < getNumVertices(); i++) {
			for (int j = 0; j < adjMatrixSquared[v][i]; j++) { // multiple edges
																// between
																// two nodes
				twoHopNeighbours.add(i);
			}

			return twoHopNeighbours;
		}
	}
}
