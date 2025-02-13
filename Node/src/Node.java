
@SuppressWarnings("unchecked")
public class Node<E> {
	// PROPERTIES
	private Object data;
	private Node<E> link;
	
	// CONSTRUCTOR
	public Node(Object initialValue, Node<E> initialLink) {
		this.data = (E)initialValue;
		this.link = initialLink;
	}
	
	// METHODS
	// Getter
	public E getData() {
		return (E)this.data;
	}
	
	public void setData(int value) {
		this.data = value;
	}
	
	// Add node
	public void addNodeAfter(E value) {
		this.link = new Node<E>(value, this.link);
	}
	
	// Remove node
	public void removeNodeAfter() {
		this.link = this.link.link;
	}
	
	// **************
	
	// Methods that work with the entire list and not just a single node.
	
	// Search list for a target value
	public static <E> Node<E> listSearch(Node<E> head, E target) {
		Node cursor;
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			if (target == cursor.data) {
				return cursor;
			}
		}
		return null;
	}
	
	// Find position on a node with value "target" 
	
	
	
	// Print all values in the list
	public static <E> String printList(Node<E> head) {
		Node<E> cursor;
		
		String list = "Head -> | ";
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			list = list + cursor.data + " | -> | ";
		}
		return list + "NULL";
	}
}
