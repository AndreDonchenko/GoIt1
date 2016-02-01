package ua.goit.andre.lab5;

public class IntArraysTools {

	public static int getMinArrayValue(final int[] arr) {
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[minIndex]) minIndex = i; 
		}
		return arr[minIndex];
	}

	public static int getMaxArrayValue(final int[] arr) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[maxIndex]) maxIndex = i; 
		}
		return arr[maxIndex];
	}

	public static int[] sortArray (final int[] arr, boolean ascending) {
		int[] sortedArray = arr.clone();
		for (int i = 0; i < sortedArray.length-1; i++) {
			for (int j = i+1; j < sortedArray.length; j++) {
				if (((sortedArray[j] < sortedArray[i]) && (ascending)) || 
					((sortedArray[j] > sortedArray[i]) && (!ascending))) {
					swap(sortedArray,i,j);
				}
			}
		}
		return sortedArray;
	}

	private static void swap(int[] arr, int i, int j) {
		int tempInt = arr[i];
		arr[i] = arr[j];
		arr[j] = tempInt;
	}
	
	public static void sortArrayBubble (int[] arr, boolean ascending) {
		for (int i = 0; i < arr.length-1; i++) {
			int bubble=i;
			for (int j = i+1 ; j < arr.length; j++) {
				if (((arr[j] < arr[bubble]) && (ascending)) || 
					((arr[j] > arr[bubble]) && (!ascending))) {
					bubble=j;
				}
			}
			if (i!=bubble) swap(arr,i,bubble);
		}	
	}
}
