import java.text.DecimalFormat;
//import java.util.Arrays;

public class Driver {

	public static  void main(String[] args) {

		final int MAX = 10000;
		int[] arr = new int[MAX];

		for(int i = 0; i < MAX - 3; i++) {
			arr[i] = (int)((Math.random() * 1000) + 3);
		}
//		int[] arr = {13,38,39,3,93,46,99,0,0,0};
//		int[] arr = {45,22,45,54,62,43,63,60,31,60,23,68,2,77,30,77,3,0,0,0};

		int target1 = 985;
		int target2 = 652;

		boolean found;
		boolean removed;


//		System.out.println("*** Array before sorting ***");
//		printArray(arr);

		int[] hashTable = new int[MAX];

		DecimalFormat formatter = new DecimalFormat("#,###");
		long start;
		long end;

		System.out.println("*** Hash Table Insert ***");
		start = (long)System.nanoTime();
		for(int i = 0; i < MAX; i++) {
//			linearHashInsert(hashTable, arr[i]);
//			quadraticHashInsert(hashTable, arr[i]);
			doubleHashInsert(hashTable, arr[i]);
//			printArray(hashTable);
		}
		end = (long)System.nanoTime();
//		printArray(hashTable);
		System.out.println("Sort time\t: " + formatter.format(Long.parseLong(String.valueOf(end - start))) + " nanoseconds.");

		System.out.printf("\n*** Search Hash Table for %d ***\n", target1);
		start = (long)System.nanoTime();
		found = linearHashSearch(hashTable, target1);
//		found = quadraticHashSearch(hashTable, target1);
		found = doubleHashSearch(hashTable, target1);
		end = (long)System.nanoTime();
		System.out.printf("Found \t\t: %b\n", found);
		System.out.println("Search time\t: " + formatter.format(Long.parseLong(String.valueOf(end - start))) + " nanoseconds.");

		System.out.printf("\n*** Remove %d from Hash Table ***\n", target1);
		start = (long)System.nanoTime();
//		removed = linearHashRemove(hashTable, target1);
//		removed = quadraticHashRemove(hashTable, target1);
		removed = doubleHashRemove(hashTable, target1);
		end = (long)System.nanoTime();
		System.out.println("Removed \t: " + removed);
//		printArray(hashTable);
		System.out.println("Remove time\t: " + formatter.format(Long.parseLong(String.valueOf(end - start))) + " nanoseconds.");

		System.out.printf("\n*** Search Hash Table for %d ***\n", target2);
		start = (long)System.nanoTime();
//		found = linearHashSearch(hashTable, target2);
//		found = quadraticHashSearch(hashTable, target2);
		found = doubleHashSearch(hashTable, target2);
		end = (long)System.nanoTime();
		System.out.printf("Found \t\t: %b\n", found);
		System.out.println("Search time\t: " + formatter.format(Long.parseLong(String.valueOf(end - start))) + " nanoseconds.");
	}

	public static void printArray(int [] arr) {
		int n = arr.length;
		System.out.print("|");
		for(int i = 0; i < n ; i++) {
			System.out.printf("%4d|", i);
		}
		System.out.println();
		System.out.print("|");
		for(int i = 0; i < n ; i++) {
			System.out.printf("%4d|", arr[i]);
		}
		System.out.println();
		System.out.println();
	}


	// HASH TABLE

	// Hash function 1
	public static int hash1(int key, int size) {
		return key % size;
	}

	// Hash function 2
	public static int hash2(int key, int size) {
		return (size - 1) + (key % (size - 1));
	}

	// Linear Probing

	// Sorting:
	public static boolean linearHashInsert(int[] hashTable, int key) {
		int size = hashTable.length;
		int bucket = hash1(key, size);
		int bucketsProbed = 0;

		while(bucketsProbed < size) {
			// Insert item in the next empty bucket
			if((hashTable[bucket] == -1) || (hashTable[bucket] == 0)) {
				hashTable[bucket] = key;
				return true;
			}
			// Increment bucket index
			bucket = (bucket + 1) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}
		return false;
	}

	// Remove
	public static boolean linearHashRemove(int[] hashTable, int key) {
		int size = hashTable.length;
		int bucket = hash1(key, size);
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				hashTable[bucket] = -1;
				return true;
			}
			// Increment bucket index
			bucket = (bucket + 1) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

	// Searching 
	public static boolean linearHashSearch(int[] hashTable, int key) {
		int size = hashTable.length;
		int bucket = hash1(key, size);
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				return true;
			}
			// Increment bucket index
			bucket = (bucket + 1) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

	// Quadratic Probing
	// Sorting:
	public static boolean quadraticHashInsert(int[] hashTable, int key) {
		int const1 = 1, const2 = 1;

		int size = hashTable.length;
		int counter = 0;
		int bucketsProbed = 0;

		int bucket = hash1(key, size); // determine the initial bucket

		while(bucketsProbed < size) {
			// Insert item in the next empty bucket
			if((hashTable[bucket] == -1) || (hashTable[bucket] == 0)) {
				hashTable[bucket] = key;
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (const1 * counter) + (const2 * (counter * counter))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}
		return false;
	}

	// Remove
	public static boolean quadraticHashRemove(int[] hashTable, int key) {

		int const1 = 1, const2 = 1;
		int counter = 0;

		int size = hashTable.length;
		int bucket = hash1(key, size); // determine the initial bucket
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				hashTable[bucket] = -1;
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (const1 * counter) + (const2 * (counter * counter))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

	// Searching 
	public static boolean quadraticHashSearch(int[] hashTable, int key) {

		int const1 = 1, const2 = 1;
		int counter = 0;

		int size = hashTable.length;
		int bucket = hash1(key, size);
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (const1 * counter) + (const2 * (counter * counter))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

	// Double Hash

	// Sorting:
	public static boolean doubleHashInsert(int[] hashTable, int key) {

		int size = hashTable.length;
		int counter = 0;
		int bucketsProbed = 0;

		int bucket = hash1(key, size); // determine the initial bucket

		while(bucketsProbed < size) {
			// Insert item in the next empty bucket
			if((hashTable[bucket] == -1) || (hashTable[bucket] == 0)) {
				hashTable[bucket] = key;
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (counter * hash2(key, size))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}
		return false;
	}

	// Remove
	public static boolean doubleHashRemove(int[] hashTable, int key) {

		int counter = 0;

		int size = hashTable.length;
		int bucket = hash1(key, size); // determine the initial bucket
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				hashTable[bucket] = -1;
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (counter * hash2(key, size))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

	// Searching 
	public static boolean doubleHashSearch(int[] hashTable, int key) {

		int counter = 0;

		int size = hashTable.length;
		int bucket = hash1(key, size);
		int bucketsProbed = 0;

		while((hashTable[bucket] != 0) && (bucketsProbed < size)) {
			if(((hashTable[bucket] != -1) || (hashTable[bucket] != 0)) && 
					(hashTable[bucket] == key)) {
				return true;
			}
			// Increment counter and recompute bucket index
			counter++;

			bucket = (hash1(key, size) + (counter * hash2(key, size))) % size;

			// Increment number of buckets probed
			++bucketsProbed;
		}

		return false;
	}

}
