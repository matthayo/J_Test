import java.text.DecimalFormat;

public class Driver {
	
	public static  void main(String[] args) {

		final int MAX = 5;
//		int[] arr = new int[MAX];
		int[] arr = {62, 89, 24, 69, 74};
//		int[] arr2, arr3, arr4, arr5, arr6;
		
		IntBSTNode bst = new IntBSTNode();

		System.out.println("++++++ ORIGINAL VALUES +++++++");
		int value;
		for(int i = 0; i < MAX; i++) {
//			value = (int)((Math.random() * 100)) + 1;
			value = arr[i];
			bst.add(value);
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		System.out.println("\n++++++ PRE-ORDER TRAVERSAL +++++++");
		bst.preorder();
		
		System.out.println("\n++++++ IN-ORDER TRAVERSAL +++++++");
		bst.inorder();
		
		System.out.println("\n++++++ POST-ORDER TRAVERSAL +++++++");
		bst.postorder();
		
		
//		System.out.println("\n++++++ REMOVE +++++++");
//		int target = 62;
//		
//		if(bst.remove(target))
//			System.out.println(target + " has been removed!");
//		else
//			System.out.println(target + " NOT found!");
//		
//		System.out.println();
//		
//		System.out.println("\n++++++ PRE-ORDER TRAVERSAL +++++++");
//		bst.preorder();
//		
//		System.out.println("\n++++++ IN-ORDER TRAVERSAL +++++++");
//		bst.inorder();
//		
//		System.out.println("\n++++++ POST-ORDER TRAVERSAL +++++++");
//		bst.postorder();
		
		System.out.println();
		
		int depth = (int)(Math.log(MAX) / Math.log(2));
		
		bst.bstPrint(depth);
	}

}
