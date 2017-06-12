package com.codefights;

import java.util.ArrayList;
import java.util.Arrays;

public class MyFilterClass {

	static ArrayList<Integer> myFilter(ArrayList<Integer> inputArray, int extraElement) {

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < inputArray.size(); i++) {
			if (inputArray.get(i) == extraElement) {
				continue;
			}
			result.add(inputArray.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	ArrayList<Integer> arrayList = new ArrayList<>();
	Integer[] array = {1, 2, 3, 2, 1, 3, 1, 2};
		arrayList.addAll(Arrays.asList(array));
		System.out.println(myFilter(arrayList,3));
	}

}
