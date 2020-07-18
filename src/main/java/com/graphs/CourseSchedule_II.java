package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_II {
	Stack<Integer> ret = new Stack<>();

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {

			adjList.add(new ArrayList<Integer>());
		}
		for (int[] arr : prerequisites) {

			adjList.get(arr[1]).add(arr[0]);
		}
		
		//Step 1: Cycle detection
		
		if(cycleExists(adjList, numCourses)) {
			return new int[] {};
		}

		//Step 2: Topologoical ordering
		boolean[] visited = new boolean[numCourses]; // 0-> 1, 2 || 1-> ||

		for (int i = 0; i < numCourses; i++) {

			if (!visited[i]) {
				dfs(adjList, i, visited, numCourses);
			}
		}

		int[] arr = new int[ret.size()];

		int i = 0;
		while (!ret.isEmpty()) {

			arr[i] = ret.pop();
			i++;
		}

		return arr;
	}

	// 0= not visited 1=visiting 2=visited
	private boolean cycleExists(List<List<Integer>> adjList, int numCourses) {
		int[]  visited = new int[numCourses];
		
		for(int i=0; i<numCourses;i++) {
			if(visited[i]==0) {
				
				if(cycleUtil(adjList, visited, i)) {
					return true;
				}
			}
		}
		
		return false;
	}

	// 0= not visited 1=visiting 2=visited
	private boolean cycleUtil(List<List<Integer>> adjList, int[] visited, int i) {
		
		if(visited[i]==1) return true;
		
		if(visited[i]==2) return false;
		
		visited[i]=1;
		
		for(int j : adjList.get(i)) {
			
			if(cycleUtil(adjList, visited, j)) {
				return true;
			}
		}
		
		visited[i]=2;
		
		return false;
	}

	private void dfs(List<List<Integer>> adjList, int currIndex, boolean[] visited, int numCourses) {

		visited[currIndex] = true;

		for (int i : adjList.get(currIndex)) {

			if (!visited[i]) {
				dfs(adjList, i, visited, numCourses);
			}

		}
		ret.push(currIndex);

	}

	public static void main(String[] args) {
		CourseSchedule_II sol = new CourseSchedule_II();

		int[] ret = sol.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });

		for (int i : ret) {

			System.out.println(i);
		}
	}
}
