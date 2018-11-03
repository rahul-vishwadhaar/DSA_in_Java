package com.greedy.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UnionAndFind {

	HashMap<Integer, HashSet<Integer>> arr = null;
	ArrayList<Vertex> vertices = null;
	int size = 0;
	boolean initialized = false;

	int distinctSets = 0;

	public UnionAndFind(ArrayList<Vertex> vertices) {
		this.size = vertices.size();
		this.vertices = vertices;
		distinctSets = size;
	}

	private void init() {
		if (initialized == true)
			return;

		arr = new HashMap<Integer, HashSet<Integer>>();

		HashSet<Integer> s;
		for (Vertex vertex : vertices) {

			s = new HashSet<Integer>();
			s.add(vertex.value);
			arr.put(vertex.value, s);
		}

	}

	public void union(int s1, int s2) {
		init();

		HashSet<Integer> set1 = arr.get(s1);
		HashSet<Integer> set2 = arr.get(s2);

		if (set2.size() > set1.size()) {
			set2.addAll(set1);

			for (Integer s : set1) {
				arr.put(s, set2);
			}
		} else {

			set1.addAll(set2);

			for (Integer s : set2) {
				arr.put(s, set1);
			}

		}
		distinctSets--;
	}

	public HashSet<Integer> find(int s1) {
		init();

		return arr.get(s1);
	}

	public HashSet<HashSet<Integer>> getClusters() {

		HashSet<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();

		Set<Integer> keys = arr.keySet();

		for (Integer key : keys) {

			set.add(arr.get(key));
		}
		return set;
	}

}
