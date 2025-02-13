
public class IntBSTNode implements IntBSTNodeInterface{
	
	IntBTNode root;
   
   public IntBSTNode(){
	   this.root = null;
   }       
   
   public void add (int element) {
	   boolean done = false;
	   
	   IntBTNode cursor = root;
	   IntBTNode newNode = new IntBTNode(element, null, null);
	   
	   if(cursor == null) {
		   // the BST is empty
		   this.root = newNode;
	   } else {
		   while(!done) {
			   if(element <= cursor.getData()) {
				   if(cursor.getLeft() == null) {
					   cursor.setLeft(newNode);
					   done = true;
				   } else {
					   cursor = cursor.getLeft();
				   }
			   } else {
				   // go to the right branch
				   if(cursor.getRight() == null) {
					   cursor.setRight(newNode);
					   done = true;
				   } else { 
					   cursor = cursor.getRight();
				   }
			   }
		   }
	   }
   }
   
   public boolean remove(int target) {
	   
	   IntBTNode cursor = root, parent = null;
	   
	   while(true) {
		   // CASE I: Target is not found
		   if(cursor == null) return false;
		   
		   // CASE II: Target is found
		   if(cursor.getData() == target) {
			   
			   // Scenario A: Target is found at root with no left child
			   if(cursor == root) {
				   root = root.getRight();
				   return true;
			   }
			   
			   // Scenario B: Target is found with no left child
			   
		   } else if (target < cursor.getData()) {
			   parent = cursor;
			   cursor = cursor.getLeft();
		   }
	   }
   }

}
           
