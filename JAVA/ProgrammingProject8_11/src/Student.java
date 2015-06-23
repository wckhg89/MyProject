/**
 * Author : Kang Hong Gu 
 * Programming Project11 in chapter8
 */
public class Student extends Person implements Comparable {
	private int studentNumber;

	public Student() {
		super();
		studentNumber = 0;
	}

	public Student(String initialName, int initialStudentNumber) {
		super(initialName);
		this.studentNumber = initialStudentNumber;
	}

	public void reset(String newName, int newStudentNumber) {
		setName(newName);
		studentNumber = newStudentNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int newStudentNumber) {
		studentNumber = newStudentNumber;
	}

	public void writeOutput() {
		System.out.println("Name : " + getName());
		System.out.println("Student Number :" + studentNumber);
	}

	public int compareTo(Object other) {
		if ((other != null) && (other instanceof Student)) {
			Student otherStu = (Student) other;
			if (this.studentNumber > otherStu.studentNumber) {
				return 1;
			} else if (this.studentNumber < otherStu.studentNumber) {
				return -1;
			} else {
				return 0;
			}
		}
		return -1;
	}
	
	
}
