package com.greedy.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalAlgo {

	public ArrayList<Edge> getMST(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {

		ArrayList<Edge> mstEdges = new ArrayList<Edge>();

		UnionAndFind str = new UnionAndFind(vertices);

		sortEdgesByCostAsc(edges);

		for (Edge edge : edges) {

			if (str.find(edge.getStartNode().value) != str.find(edge.getEndNode().value)) {
				mstEdges.add(edge);
				str.union(edge.getStartNode().value, edge.getEndNode().value);
			} else {

				edge.getStartNode().removeEdge(edge);
				edge.getEndNode().removeEdge(edge);

			}
		}

		return mstEdges;
	}

	private ArrayList<Edge> sortEdgesByCostAsc(ArrayList<Edge> edges) {

		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {

				if (e1.getCost() > e2.getCost())
					return -1;

				return 1;
			}
		});

		return edges;
	}
}
