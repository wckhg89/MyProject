/**
 * Programming Project 12_12 200932220 °­ È« ±¸
 * 
 * @author honggu
 * 
 */
public class DoublyLinkedList {
	private Node head;
	private Node pre_node;
	private Node tail;

	/*
	 * adding node to head
	 */
	public void addNode(String tmp) {
		if (head == null) {
			head = new Node(tmp, null, null);
		} else {
			pre_node = head;
			head = new Node(tmp, pre_node, null);
			pre_node.left_Node = head;

		}
	}

	// show list head to tail
	public void showHeadToTail() {
		Node position = head;
		while (true) {
			System.out.println(position.data);
			if (position.right_Node == null) {
				break;
			}
			position = position.right_Node;

		}

	}

	// show list tail to head
	public void showTailToHead() {
		Node position = head;
		while (true) {
			if (position.right_Node == null) {
				break;
			}
			position = position.right_Node;

		}
		while (true) {
			System.out.println(position.data);
			if (position.left_Node == null) {
				break;
			}
			position = position.left_Node;
		}

	}

	public static void main(String[] args) {
		DoublyLinkedList test = new DoublyLinkedList();
		test.addNode("1");
		test.addNode("2");
		test.addNode("3");
		test.addNode("4");

		test.showHeadToTail();
		System.out.println("=================");
		test.showTailToHead();

	}

	private class Node {
		private String data;
		private Node right_Node;
		private Node left_Node;

		public Node(String data, Node right, Node left) {
			this.data = data;
			this.right_Node = right;
			this.left_Node = left;
		}
	}
}
