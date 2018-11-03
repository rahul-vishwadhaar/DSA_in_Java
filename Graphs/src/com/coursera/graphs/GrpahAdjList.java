package com.coursera.graphs;

import java.util.ArrayList;
import java.util.List;

public class GrpahAdjList extends Graph {

	public List<Integer> getNeighbours(int v) {

		return new ArrayLis<Integer>(adjListMap.get(v));
	}

     public List<Integer> getTwoHopNeighbours(int v){
		
		List<Integer> neighbours = new ArrayList<Integer>();
		
		return neighbours;
	}
}
