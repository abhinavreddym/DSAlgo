package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	List<List<Integer>> ret = new ArrayList<>();
	ArrayList<Integer> ls = new ArrayList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		int target = graph.length - 1;

		dfs(graph, target, 0);

		return ret;
	}

	private void dfs(int[][] graph, int target, int index) {

		ls.add(index);

		if (index == target) {

			ret.add((ArrayList<Integer>)ls.clone());

		} else {
			for (int i : graph[index]) {

				dfs(graph, target, i);
			}
		}

		ls.remove(ls.size() - 1);
	}
	
	
	//Find the path from 0 to graph size -1
	public static void main(String[] args) {
		AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
		
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2}, {3}, {3}, {}}));
	}
}
