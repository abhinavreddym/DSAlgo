package com.circulararray;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int diff = 0;
		for (int i = 0; i < gas.length; i++) {

			diff = diff + (gas[i] - cost[i]);

		}

		if (diff < 0)
			return -1;

		int start = 0;
		int i = 0;

		while (i < gas.length) {

			System.out.println(i);
			
			int deficit = 0;
			start = i;
			for (int j = i; j < gas.length; j++) {

				deficit = deficit + (gas[j] - cost[j]);

				
				i = j + 1;

				if (deficit < 0) {

					break;
				}
			}
			// i=j+1;
		}

		return start;
	}
	
	public static void main(String[] args) {
		GasStation obj = new GasStation();
		obj.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2});
	}

}
