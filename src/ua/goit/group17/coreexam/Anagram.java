package ua.goit.group17.coreexam;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Anagram {


	/**
	 * Checks 2 words if they are anagrams.
	 * @param s1 - first word
	 * @param s2 - second word
	 * @return {@code Boolean} true if they are anagrams, false otherwise
	 */
	public static boolean isAnagram(String str1, String str2){
		if ((null==str1) || (null==str2)) return false;
		if (str1.length()!=str2.length()) return false;
		if (str1.compareToIgnoreCase(str2)==0) return false;
		
		char[] charsStr1 = str1.toUpperCase().toCharArray();
		char[] charsStr2 = str2.toUpperCase().toCharArray();

		Arrays.sort(charsStr1);
		Arrays.sort(charsStr2);

		return Arrays.equals(charsStr1, charsStr2);
	}

	/**
	 * Get anagram words from List of words
	 * @param words - list of words
	 * @return {@code List<String>} anagrams pairs List, splitted with ', '
	 */
	public static List<String> getAnagramsFromList(List<String> words) {
		LinkedList<String> resultList = new LinkedList<>();
		StringBuilder resultString;
		boolean isFindAnagram;

		if ((null==words) || (null==words) || (words.size()==0)) return resultList;

		for (String s1: words) {
			resultString=new StringBuilder(s1);
			isFindAnagram=false;
			
			for (String s2: words) {
					if (isAnagram(s1, s2)) {
						isFindAnagram = true;
						resultString.append(", ").append(s2);
					}
			}
			if (isFindAnagram) resultList.add(resultString.toString());
		}
		return resultList;
	}

	/**
	 * Gets first anagram in list
	 * @param words - List of words to check on anagrams
	 * @param str - checking word
	 * @return {@code String} anagram word
	 */
	public static String getAnagramInList(List<String> wordsList, String word) {
		if ((null==word) || (null==wordsList) || (wordsList.size()==0)) return "";
		for (String s: wordsList) {
			if (isAnagram(word, s)) return s;
		}
		return "";
	}
}
