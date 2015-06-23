import java.util.Arrays;
/**
 * Author : Kang Hong Gu 
 * Programming Project11 in chapter8
 */
public class Test {
	public static void main(String[] args) {
		Student[] test = new Student[5];
		test[0] = new Student("A", 1);
		test[4] = new Student("B", 2);
		test[3] = new Student("C", 3);
		test[1] = new Student("D", 4);
		test[2] = new Student("F", 5);

		for (int j = 0; j < 4; j++) {
			Student min = test[j];
			int minIndex = j;
			for (int i = j+1; i < 5; i++) {
				if (test[i].compareTo(test[j]) == 1) {
					continue;
				} else if (test[i].compareTo(test[j]) == -1) {
					min = test[i];
					minIndex = i;
				} else if (test[i].compareTo(test[j]) == 0) {
					min = test[i];
					minIndex = i;
				}
			}
			Student temp = test[j];
			test[j] = test[minIndex];
			test[minIndex] = temp;
		}
		for(int i=0 ; i<5 ;i++)
		{
			System.out.print(test[i].getStudentNumber());
			System.out.println(test[i].getName());
		}
	}
	

}
