
public class IntBTNode{
	
   // Invariant of the IntBTNode class:
   //   1. Each node has one integer value, stored in the instance variable data.
   //   2. The instance variables left and right are references to the node's
   //      left and right children.
	
   private int data;
   private IntBTNode left, right;   

   
   public IntBTNode(int initialData, IntBTNode initialLeft, IntBTNode initialRight)
   {
      data = initialData;
      left = initialLeft;
      right = initialRight;
   }       
   
   public int getData( )   
   {
      return data;
   }
   
   public IntBTNode getLeft( )
   {
      return left;                                               
   } 
   
   public int getLeftmostData( )
   {
      if (left == null)
         return data;
      else
         return left.getLeftmostData( );
   }
      
   public IntBTNode getRight( )
   {
      return right;                                               
   } 

   public int getRightmostData( )
   {
      if (left == null)
         return data;
      else
         return left.getRightmostData( );
   }
   
   public void inorderPrint( )
   {
      if (left != null)
         left.inorderPrint( );
      System.out.println(data);
      if (right != null)
         right.inorderPrint( );
   }  

   public boolean isLeaf( )
   {
      return (left == null) && (right == null);                                               
   } 

   public void preorderPrint( )
   {
      System.out.println(data);
      if (left != null)
         left.preorderPrint( );
      if (right != null)
         right.preorderPrint( );
   } 
   
   public void postorderPrint( )
   {
      if (left != null)
         left.postorderPrint( );
      if (right != null)
         right.postorderPrint( );
      System.out.println(data);
   }   

   public void print(int depth)
   {
      int i;
   
      // Print the indentation and the data from the current node:
      for (i = 1; i <= depth; i++)
         System.out.print("    ");
      System.out.println(data);

      // Print the left subtree (or a dash if there is a right child and no left child)   
      if (left != null)
         left.print(depth+1);
      else if (right != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }

      // Print the right subtree (or a dash if there is a left child and no left child)  
      if (right != null)
         right.print(depth+1);
      else if (left != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }
   }

   public IntBTNode removeLeftmost( )
   {
      if (left == null)
         return right;
      else
      {
         left = left.removeLeftmost( );
         return this;
      }
   }

   public IntBTNode removeRightmost( )
   {
      if (right == null)
         return left;
      else
      {
         right = right.removeRightmost( );
         return this;
      }
   }
       
  
   public void setData(int newData)   
   {
      data = newData;
   }                                                               
   
   public void setLeft(IntBTNode newLeft)
   {                    
      left = newLeft;
   }
    
   public void setRight(IntBTNode newRight)
   {                    
      right = newRight;
   }  
    
   public static IntBTNode treeCopy(IntBTNode source)
   {
	   IntBTNode leftCopy, rightCopy;

      if (source == null)
         return null;
      else
      {
         leftCopy = treeCopy(source.left);
         rightCopy = treeCopy(source.right);
         return new IntBTNode(source.data, leftCopy, rightCopy);
      }
   }
   
   public static long treeSize(IntBTNode root)
   {
      if (root == null)
         return 0;
      else
         return 1 + treeSize(root.left) + treeSize(root.right);
   }   

}
           
