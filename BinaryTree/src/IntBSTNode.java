
public class IntBSTNode implements IntBSTNodeInterface{
	// PROPERTY
	private IntBTNode root;
	
	// CONSTRUCTOR
	public IntBSTNode() {
		this.root = null;
	}
	
	@Override
	public void add(int element) {
		
		IntBTNode cursor = this.root;
		IntBTNode newNode = new IntBTNode(element, null, null);
		
		boolean done = false;
		
		if(cursor == null)
			// If the tree is empty we add the newNode at root
			this.root = newNode;
		else {
			while(!done) {
				if(element <= cursor.getData()) {
					// Go down the left subtree
					if(cursor.getLeft() == null) {
						// current node has no left child
						cursor.setLeft(newNode);
						done = true;
					} else {
						// current node has a left child, go down its left subtree
						cursor = cursor.getLeft();
					}
				} else {
					// element is greater that data at current node
					// Go down the right subtree
					if(cursor.getRight() == null) {
						// current node has not right child
						cursor.setRight(newNode);
						done = true;
					} else {
						// current node has right child, go down its right subtree
						cursor = cursor.getRight();						
					}
				}
			} // End of while
		} // End of if-else
	}

	@Override
	public boolean remove(int target) {
		
		IntBTNode cursor = this.root;
		IntBTNode parent = null;
		
		while(true) {
			// CASE I: Target is not found
			if(cursor == null) {
				return false;
			}
			// CASE II: Target is found
			if(cursor.getData() == target) {
				// SCENARIO I: Target found with no left child
				if(cursor.getLeft() == null) {
					// CONDITION I: Target found at root and has no left child
					if(cursor == this.root) {
						this.root = this.root.getRight();
						return true;
					}
					// CONDITION II: Target has right child with not left child
					if(cursor == parent.getLeft()) {
						parent.setLeft(cursor.getRight());
					} 
					// CONDITION III: Target is the right child with not left child
					else {
						parent.setRight(cursor.getRight());
					}
					return true;
				}
				// SCENARIO II: Target found and has left child/subtree
				else {
					cursor.setData(cursor.getLeft().getRightmostData());
					cursor.setLeft(cursor.getLeft().removeRightmost());
					return true;
				}
			} 
			// CASE III: Target not at cursor but less than value at current node
			else if (target < cursor.getData()){
				// Go down the left subtree
				parent = cursor;
				cursor = cursor.getLeft();
			} 
			// CASE IV: Target not found but greater than value at current node
			else {
				// Go down the right subtree
				parent = cursor;
				cursor = cursor.getRight();
			}
		}
	}
	
	public void preorder() {
		preorderDisplay(this.root);
		System.out.println();
	}
	
	public void preorderDisplay(IntBTNode root) {
		if(root != null) {
			System.out.print(root.getData() + " ");
			preorderDisplay(root.getLeft());
			preorderDisplay(root.getRight());
		}
	}
	
	
	public void inorder() {
		inorderDisplay(this.root);
		System.out.println();
	}
	
	public void inorderDisplay(IntBTNode root) {
		if(root != null) {
			inorderDisplay(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderDisplay(root.getRight());
		}
	}
	
	
	public void postorder() {
		postorderDisplay(this.root);
		System.out.println();
	}
	
	public void postorderDisplay(IntBTNode root) {
		if(root != null) {
			postorderDisplay(root.getLeft());
			postorderDisplay(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	public void bstPrint(int depth) {
		this.root.display(depth);
	}
}











