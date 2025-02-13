
public interface IntBTNodeInterface {
	
	// List method stubs
	// GETTERS
	public int getData();
	public IntBTNode getLeft();
	public IntBTNode getRight();
	// SETTERS
	public void setData(int element);
	public void setLeft(IntBTNode newLeft);
	public void setRight(IntBTNode newRight);
	// MEMBER METHODS
	public int getLeftmostData();
	public int getRightmostData();
	
	public IntBTNode removeLeftmost();
	public IntBTNode removeRightmost();
	
	public boolean isLeaf();
}
