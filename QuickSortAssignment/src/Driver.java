//import java.util.Arrays;

public class Driver {

	// QUICKSORT => End as pivot
	public static void quickSortEnd(int[] arr, int start, int end) {

		if(start < end) {
			int pivot = partitionEnd(arr, start, end);

			quickSortEnd(arr, start, pivot - 1);
			quickSortEnd(arr, pivot + 1, end);
		}
	}

	// QUICKSORT => Start as pivot
	public static void quickSortStart(int[] arr, int start, int end) {

		if(start < end) {
			int pivot = partitionStart(arr, start, end);

			quickSortStart(arr, start, pivot - 1);
			quickSortStart(arr, pivot + 1, end);
		}
	}

	// QUICKSORT => Random value as pivot
	public static void quickSortMedian(int[] arr, int start, int end) {

		if(start < end) {
			int pivot = partitionRandom(arr, start, end);

			quickSortMedian(arr, start, pivot - 1);
			quickSortMedian(arr, pivot + 1, end);
		}
	}

	public static int partitionEnd(int[] arr, int start, int end) {

		int pivot = arr[end];

		int i = start - 1;

		for(int j = start; j < end; j++) {
			if(arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		//		printArray(arr);

		return i + 1;
	}

	public static int partitionStart(int[] arr, int start, int end) {

		int pivot = arr[start];

		int i = end + 1;

		for(int j = end; j > start; j--) {
			if(pivot < arr[j]) {

				i--;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i - 1];
		arr[i - 1] = arr[start];
		arr[start] = temp;

		return i - 1;
	}

	public static int partitionRandom(int[] arr, int start, int end) {

		int rand = (int)(Math.random() * (end - start)) + start;

		int temp1 = arr[end];
		arr[end] = arr[rand];
		arr[rand] = temp1;

		return partitionEnd(arr, start, end);
	}

	public static void printArray(int[] arr, int left, int right) {
		int n = left - right;
		System.out.print("{");
		if(n >= 10)
			System.out.println();
		for (int i = left; i <= right; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("}\n");
	}

	public static void printArray(int[] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("}\n");
	}

	public static void main(String[] args) {

		final int ARRAY_LENGTH = 10;

		int[] arr = {77, 59, 72, 82, 7, 58, 30, 81, 12, 32};
		int[] arr1 = {77, 59, 72, 82, 7, 58, 30, 81, 12, 32};
		int[] arr2 = {77, 59, 72, 82, 7, 58, 30, 81, 12, 32};


		//		int[] arr = new int[ARRAY_LENGTH];
		//		int[] arr1;
		//
		//
		//		System.out.println("Populating array. \nPlease wait ...");
		//		for(int i = 0; i < arr.length; i++) {
		//			arr[i] = (int)((Math.random() * 100) + 1);
		//		}
		//
		//		arr1 = Arrays.copyOf(arr, ARRAY_LENGTH);





		// Quicksort using last value as pivot
		System.out.println("=================== QUICKSORT USING LAST VALUE IN ARRAY AS PIVOT ===================\n");
		System.out.print("\tUnsorted Array: ");
		printArray(arr);
		System.out.println();
		System.out.println("\tSorting the array. \n\tPlease wait ....\n");

		long start;
		long end;
		start = (long)System.nanoTime();
		quickSortEnd(arr, 0, ARRAY_LENGTH - 1);
		end = (long)System.nanoTime();
		System.out.print("\tSorted Array: "); 
		printArray(arr);
		System.out.println();
		System.out.println("\tTime: " + (end - start) + " nanoseconds.");

		// Quicksort using start value as pivot
		System.out.println("=================== QUICKSORT USING START VALUE IN ARRAY AS PIVOT ===================\n");
		System.out.print("\tUnsorted Array: ");
		printArray(arr1);
		System.out.println();
		System.out.println("\tSorting the array. \n\tPlease wait ....\n");

		long start1;
		long end1;
		start1 = (long)System.nanoTime();
		quickSortStart(arr1, 0, ARRAY_LENGTH - 1);
		end1 = (long)System.nanoTime();
		System.out.print("\tSorted Array: "); 
		printArray(arr1);
		System.out.println();
		System.out.println("\tTime: " + (end1 - start1) + " nanoseconds.");

		// Quicksort using Random value as pivot
		System.out.println();
		System.out.println("=========== QUICKSORT USING MEDIAN OF 3 RANDOM VALUES IN ARRAY AS PIVOT ===========\n");
		System.out.print("\tUnsorted Array: ");
		printArray(arr2);
		System.out.println();
		System.out.println("\tSorting the array. \n\tPlease wait ....\n");
		
		long start3;
		long end3;
		start3 = (long)System.nanoTime();
		quickSortMedian(arr2, 0, ARRAY_LENGTH - 1);
		end3 = (long)System.nanoTime();
		System.out.print("\tSorted Array: ");
		printArray(arr2);
		System.out.println();
		System.out.println("\tTime: " + (end3 - start3) + " nanoseconds.");

		System.out.println("\n++++++++++++++++++++++++++++++++++ END OF SORTING +++++++++++++++++++++++++++++++++");
	}

}
