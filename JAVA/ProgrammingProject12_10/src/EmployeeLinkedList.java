import java.util.Scanner;
/**
 * Programming Project 12_10
 * 200932220 碍 全 备 
 * @author honggu
 *
 */
public class EmployeeLinkedList {
	private ListNode head;
	//constructor
	public EmployeeLinkedList() {
		head = null;
	}
	//show allist of linked list
	public void showList() {
		ListNode position = head;
		while (position != null) {
			System.out.println("Name is " + position.data.name);
			System.out.println("Social number is " + position.data.social_num);
			System.out.println("-------------------------------------------");
			position = position.link;
		}
	}
	//adding node.
	public void addNode(Employee data) {
		head = new ListNode(data, head);
	}

	//search node.
	public void searchNode(int searchNum) {
		ListNode position = head;
		while (position != null) {
			if (position.data.social_num == searchNum) {
				System.out.println("Name is " + position.data.name);
				System.out.println("Social number is "
						+ position.data.social_num);
				break;
			}
			position = position.link;
		}
		if (position == null) {
			System.out.println("This is not found!");
		}

	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("碍全9", 1);
		Employee e2 = new Employee("碍全8", 2);
		Employee e3 = new Employee("碍全7", 3);
		Employee e4 = new Employee("碍全6", 4);
		Employee e5 = new Employee("碍全5", 5);
		Employee e6 = new Employee("碍全4", 6);
		Employee e7 = new Employee("碍全3", 7);
		Employee e8 = new Employee("碍全2", 8);
		Employee e9 = new Employee("碍全1", 9);

		EmployeeLinkedList test1 = new EmployeeLinkedList();
		test1.addNode(e1);
		test1.addNode(e2);
		test1.addNode(e3);
		test1.addNode(e4);
		test1.addNode(e5);
		test1.addNode(e6);
		test1.addNode(e7);
		test1.addNode(e8);
		test1.addNode(e9);

		test1.showList();
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out
					.print("Enter the social number that you want to found : ");
			int num = keyboard.nextInt();
			test1.searchNode(num);
			if (num <= 0) {
				System.out.println("End of program.");
				System.exit(0);
			}
		}

	}
	/**
	 * inner class : ListNode
	 * @author honggu
	 *
	 */
	private class ListNode {
		private Employee data;
		private ListNode link;

		public ListNode(Employee newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}
}
