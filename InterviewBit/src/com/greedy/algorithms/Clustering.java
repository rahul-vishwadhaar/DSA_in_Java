/**
 * 
 */
package com.greedy.algorithms;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author rahul
 *
 */
public class Clustering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public HashSet<HashSet<Integer>> getClusters(int k) {

		ArrayList<Vertex> vertices = null;

		UnionAndFind str = new UnionAndFind(vertices);

		ArrayList<Edge> edges = null;

		for (Edge edge : edges) {

			if (str.distinctSets >= k)
				return str.getClusters();

			if (str.find(edge.getStartNode().value) != str.find(edge.getEndNode().value)) {
				str.union(edge.getStartNode().value, edge.getEndNode().value);
			} else {

				edge.getStartNode().removeEdge(edge);
				edge.getEndNode().removeEdge(edge);

			}
		}

		return str.getClusters();

	}

}
