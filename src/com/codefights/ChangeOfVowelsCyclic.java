package com.codefights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Templates;

public class ChangeOfVowelsCyclic {

	static String changeOfVowelsInCycle(int cycle, String text) {

		text = new StringBuilder(text).reverse().toString();
		System.out.println("reverse String:" + text);

		List<Character> vowelsList = new ArrayList<>();
		List<Character> vowelsListOther = new ArrayList<>();
		vowelsList.add('a');
		vowelsList.add('e');
		vowelsList.add('i');
		vowelsList.add('o');
		vowelsList.add('u');
		vowelsList.add('A');
		vowelsList.add('E');
		vowelsList.add('I');
		vowelsList.add('O');
		vowelsList.add('U');

		// int[] occurenceCounter = new int[10];
		int vowelCount = 0;
		int[] occurencePosition = new int[100];
		char[] occurenceNewPosition = new char[100];
		// int[] valueArray = new int[2];
		for (int i = 0; i < text.length(); i++) {
			int[] valueArray = new int[2];
			if (vowelsList.contains(text.charAt(i))) {
				occurencePosition[i] = text.charAt(i);
				vowelCount++;
			}
		}
		cycle %= vowelCount;

		int i = 0;
		for (int j = 0; j < text.length(); j++) {
			if (occurencePosition[j] != 0) {
				i++;
				vowelsListOther.add((char) occurencePosition[j]);
			}
			if (i == vowelCount - 1) {
				i = j;
				break;
			}
		}
		int count = 0, j = cycle;
		System.out.println("vowelsListOther:" + vowelsListOther + " cycle:" + cycle+" vowelCount :"+vowelCount);

		while (count < text.length()) {
			if (occurencePosition[i] != 0) {
				occurenceNewPosition[i] = vowelsListOther.get(j);
				if (j == vowelsListOther.size() - 1)
					j = 0;
				else
					j++;
			} else {
				occurenceNewPosition[i] = text.charAt(i);
			}

			if (i == text.length() - 1)
				i = 0;
			else
				i++;
			count++;
		}
		return new String(occurenceNewPosition, 0, text.length());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(changeOfVowelsInCycle(3, "this test is of potato"));
	}

}
