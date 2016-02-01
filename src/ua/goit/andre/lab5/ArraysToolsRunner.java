package ua.goit.andre.lab5;

import java.util.Arrays;

public class ArraysToolsRunner {
		
	public static void main(String[] args) {		
		int[] testArray = {5, 2, 15, 78, 135, 1};
		System.out.println("Tested array: " + Arrays.toString(testArray)); 
		System.out.println("MinValue: " + IntArraysTools.getMinArrayValue(testArray));
		System.out.println("MaxValue: " + IntArraysTools.getMaxArrayValue(testArray));
		int[] resultArray = IntArraysTools.sortArray(testArray, true);
		System.out.println("In Ascending order: " + Arrays.toString(resultArray));
		
		System.out.println("Tested array: " + Arrays.toString(testArray)); 
		
		resultArray = IntArraysTools.sortArray(testArray, false);
		System.out.println("In Descending order: " + Arrays.toString(resultArray));

		IntArraysTools.sortArrayBubble(testArray, true);
		System.out.println("In Ascending order by Bubble: " + Arrays.toString(testArray));

		IntArraysTools.sortArrayBubble(testArray, false);
		System.out.println("In Descending order by Bubble: " + Arrays.toString(testArray));

	}
}
