package com.stuff.learn.ds.graph;

public class MinimizeCashFlow {

	public static void main(String[] args) {
		int[][] cashGraph = new int[][] { { 0, 200, 800 }, { 0, 0, 800 }, { 0, 0, 0 } };
		minimizeCashFlow(cashGraph);
	}

	private static void minimizeCashFlow(int[][] cashGraph) {
		int[] netAmounts = getNetAmount(cashGraph);
		minimizeCashFlow(netAmounts);
	}

	private static void minimizeCashFlow(int[] netAmounts) {
		
		int maxCreditPerson = getMaxAmountPerson(netAmounts);
		int maxDebitPerson = getMinAmountPerson(netAmounts);
		
		//base case
		if (netAmounts[maxCreditPerson] == 0 && netAmounts[maxDebitPerson] == 0) {
            return;
        }
		
		int min = Math.min(-netAmounts[maxDebitPerson], netAmounts[maxCreditPerson]);
		netAmounts[maxCreditPerson] -= min;
		netAmounts[maxDebitPerson] += min;
		System.out.println("Person(" + maxDebitPerson + ") pays " + min + " to Person(" + maxCreditPerson + ")");
		minimizeCashFlow(netAmounts);

	}

	private static int getMaxAmountPerson(int[] netAmounts) {

		int maxPerson = 0;
		for (int i = 1; i < netAmounts.length; i++) {
			if (netAmounts[i] > netAmounts[maxPerson]) {
				maxPerson = i;
			}
		}
		return maxPerson;
	}

	private static int getMinAmountPerson(int[] netAmounts) {

		int minPerson = 0;
		for (int i = 1; i < netAmounts.length; i++) {
			if (netAmounts[i] < netAmounts[minPerson]) {
				minPerson = i;
			}
		}
		return minPerson;
	}

	private static int[] getNetAmount(int[][] cashGraph) {
		int[] netAmounts = new int[cashGraph.length];
		for (int i = 0; i < cashGraph.length; i++) {
			for (int j = 0; j < cashGraph.length; j++) {
				netAmounts[i] += cashGraph[j][i] - cashGraph[i][j];
			}
		}
		return netAmounts;
	}

}
