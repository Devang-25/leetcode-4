package com.codefights;

import java.util.Arrays;

public class WordsRotationCC {

	static String[] wordsRotationCc(String[] words) {

		char[][] matrixChar = new char[words.length][words[0].length()];

		char[][] answerChar = new char[words[0].length()][words.length];

		for (int i = 0; i < words.length; i++) {
			matrixChar[i] = words[i].toCharArray();
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[0].length(); j++) {
				answerChar[j][i] = matrixChar[i][words[0].length() - j - 1];
			}
		}
		String[] answer = new String[answerChar.length];
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < answerChar.length; i++) {
			sBuilder.setLength(0);
			answer[i] = sBuilder.append(answerChar[i]).toString();
		}

		return answer;
	}

	public static void main(String[] args) {

		String[] words = { "apple", "anger", "monks", "stink" };
		System.out.println(Arrays.asList(wordsRotationCc(words)));

	}

}
