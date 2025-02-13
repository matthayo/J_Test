
public class Driver {
	
	public static void main(String[] args) {
		
		Node<Double> node1 = new Node<Double>(45.0, null);
		Node head = node1;
		System.out.println(Node.printList(head));
		
	for (int i = 0; i < 5; i++) {
		node1.addNodeAfter((double)(Math.random() * 100));
		System.out.println(Node.printList(head));
	}
		
//	System.out.println(node1.displayNodes());
		
		Node<Double> node2 = new Node<Double>(34.0, node1);
		head = node2;
		
		
		System.out.println(Node.printList(head));
//		System.out.println(head.toString());
	}


}
