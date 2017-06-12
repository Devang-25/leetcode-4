package com.codefights;

import java.util.ArrayList;

public class TextJustificationClass {

	static String[] textJustification(String[] words, int L) {

		ArrayList<String> textJustAnsList = new ArrayList<>();
		ArrayList<String> stringLine = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int wordIndex = 0, spaces = 0, lineLength = 0;
		while (wordIndex < words.length) {
			// Initializing the individual line variables
			sb.setLength(0);
			stringLine.clear();
			spaces = 0;
			lineLength = 0;

			// accomodating all the individual words in the line
			/// and preparing for the next step of space induction
			while (sb.length() + words[wordIndex].length() <= L && wordIndex < words.length) {
				sb.append(words[wordIndex]);
				stringLine.add(words[wordIndex]);
				if (!(sb.length() == L))
					sb.append(" ");
				wordIndex++;
				if (wordIndex == words.length)
					break;
			}
			// remove extra space at the end except for the last line of the new
			// String Array

			if (sb.indexOf(" ", sb.length() - 1) >= 0)
				sb.deleteCharAt(sb.length() - 1);
			spaces = L - sb.length();
			System.out.println("sb Value Before: " + sb.toString() + " wordIndex " + wordIndex + " spaces " + spaces
					+ " stringLine " + stringLine);

			// addition of the additionl spaces
			if (spaces > 0 && wordIndex < words.length && stringLine.size() > 1) {

				int equalSpace = 0, extraSpace = 0;
				// if only one extra space is not there
				if ((stringLine.size() - 1) <= 1) {
					extraSpace = 0;
					equalSpace = spaces;
				}
				// addition of the space based on the equal spaces
				else {
					equalSpace = spaces / (stringLine.size() - 1);
					extraSpace = spaces % (stringLine.size() - 1);
				}

				// addition of the space based on the equal spaces
				for (int i = 0; i < stringLine.size() - 1; i++) {
					StringBuilder spaceString = new StringBuilder();
					for (int count = 0; count < equalSpace; count++) {
						spaceString.append(" ");
					}
					//addition of the spaces based on the extra space logic
					if (extraSpace > 0) {
						spaceString.append(" ");
						extraSpace--;
					}
					// spaces removed based on the spaces added
					spaces -= spaceString.length();
					//lineLength
					lineLength += stringLine.get(i).length() + 1;

					sb.insert(lineLength, spaceString);
					lineLength += spaceString.length();
					System.out.println("lineLength: " + lineLength + " spaceString.size " + spaceString.length()
							+ " equalSpace " + equalSpace + " extraSpace " + extraSpace + " sb " + sb.toString());
				}
			}

			//When only one word is present in the line and it
			else if (spaces > 0 && wordIndex < words.length && stringLine.size() == 1) {
				while (spaces > 0) {
					sb.append(" ");
					spaces--;
				}
			}//Final Line spaces management to be added as part of the spaces to be appended
			else if (spaces > 0 && wordIndex == words.length) {
				while (spaces > 0) {
					sb.append(" ");
					spaces--;
				}
			}
			System.out.println("sb Value After:" + sb.toString() + " wordIndex " + wordIndex + " spaces " + spaces);

			textJustAnsList.add(sb.toString());

		}
		System.out.println(textJustAnsList);
		return textJustAnsList.parallelStream().toArray(String[]::new);
	}

	public static void main(String[] args) {
		String[] words = { "Two", "words." };
		String[] ans = textJustification(words, 9);
		System.out.println("Answer is:");
		for (String string : ans) {
			System.out.println(string + ",");
		}
	}

}
