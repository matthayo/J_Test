
public class IntBTNode implements IntBTNodeInterface {
	
	// PROPERTIES
	private int data;
	private IntBTNode left;
	private IntBTNode right;
	
	// CONSTRUCTOR
	public IntBTNode (int initData, IntBTNode initLeft, IntBTNode initRight) {
		this.data = initData;
		this.left = initLeft;
		this.right = initRight;
	}
	
	// METHODS
	
	// Getters
	@Override
	public int getData() {
		return this.data;
	}

	@Override
	public IntBTNode getLeft() {
		return this.left;
	}

	@Override
	public IntBTNode getRight() {
		return this.right;
	}

	@Override
	public void setData(int element) {
		this.data = element;
	}

	@Override
	public void setLeft(IntBTNode newLeft) {
		this.left = newLeft;
	}

	@Override
	public void setRight(IntBTNode newRight) {
		this.right = newRight;
	}

	@Override
	public int getLeftmostData() {
		// Recursively go down to the leftmost node of the subtree/tree
		
		// Stopping condition
		if(this.left == null)
			return this.data;
		else 
			// Going down the left subtree
			return this.left.getLeftmostData();
	}

	@Override
	public int getRightmostData() {
		// Recursively go down to the rightmost node of the subtree/tree
		
		// Stopping condition
		if(this.right == null)
			return this.data;
		else
			// Go down the right subtree
			return this.right.getRightmostData();
	}

	@Override
	public IntBTNode removeLeftmost() {
		
		if (this.left == null)
			return this.right;
		else {
			this.left = this.left.removeLeftmost();
			return this;
		}
	}

	@Override
	public IntBTNode removeRightmost() {
		
		if(this.right == null)
			return this.left;
		else {
			this.right = this.right.removeRightmost();
			return this;
		}
	}

	@Override
	public boolean isLeaf() {
		return (this.left == null) && (this.right == null);
	}
	
	public void display(int depth) {
		
		int i;
		
		for(i = 1; i <= depth; i++)
			System.out.printf("%10s", " ");
		System.out.println(this.data);
	
		
		if(this.left != null) {
			left.display(depth + 1);
		} else if (right != null) {
			for (i = 1; i <= depth+1; i++) {
				System.out.printf("%10s", " ");
			}
			System.out.println("--");
		}
		
		if(right != null)
			right.display(depth + 1);
		else if (left != null) {
			for(i = 1; i <= depth + 1; i++)
				System.out.printf("%-10s", " ");
			System.out.println("--");
		}
			
	}

}