public class LinkedList{

	public class Node {
		@SuppressWarnings("unused")
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}

	}

	public Node head = null;

	public void addAtEnd(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
		}else {
			Node current = head;
			while(current.next != null) {
				current = head;
				current = current.next;
			}
			current.next = newNode;
		}
	}
}