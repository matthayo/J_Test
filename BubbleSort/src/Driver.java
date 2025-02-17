class Driver
{
    static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                printArray(arr);
            }
    }
  
    /* Prints the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver method to test above
    public static void main(String args[])
    {
//    	int[] arr = new int[5];
//    	
//    	for (int i = 0; i < arr.length; i++) {
//    		arr[i] = (int)(Math.random() * 100);
//    	}
    	
    	int[] arr = {43, 84, 24, 29, 45};
    	
        System.out.println("Unsorted array");
        printArray(arr);
        
        System.out.println("\nSorting the array");
        bubbleSort(arr);
        
        System.out.println("\nSorted array");
        printArray(arr);
    }
}
