package com.rays.junit;

public class ArrayClass {

	public static int findMaxArray(int[] i) {

		int max = i[0];

		for (int j = 0; j < i.length; j++) {

			if (i[j] > max) {
				max = i[j];
			}

		}
		return max;
	}

	public static int findMinArray(int[] i) {

		int max = i[0];

		for (int j = 0; j < i.length; j++) {

			if (i[j] < max) {
				max = i[j];
			}

		}
		return max;

	}
}
