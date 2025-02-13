
public class Driver {
	
	public static void main(String[] args) {
		
		IntNode node = new IntNode(15, null);
		IntNode head = node;
		
		node.add(56);
		node.add(89);
		node.add(45);
		
		System.out.println(head.printList(head));
		
	}
}
