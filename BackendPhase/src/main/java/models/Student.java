package models;

public class Student {
	protected int studentId;
	protected String studentName;
	protected int rollNo;
	protected String className;
	
	public Student() {
		super();
	}
     
	
	public Student(String studentName, int rollNo, String className) {
		super();
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.className = className;
	}


	public Student(int studentId, String studentName, int rollNo, String className) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.className = className;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	

	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo
				+ ", className=" + className + "]";
	}
	
	

}
