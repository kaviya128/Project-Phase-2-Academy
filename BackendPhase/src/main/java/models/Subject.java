package models;

public class Subject {
	protected int subjectId;
	protected String subjectName;
	protected String className;
	
	public Subject() {
		super();
	}

	public Subject(String subjectName, String className) {
		super();
		this.subjectName = subjectName;
		this.className = className;
	}

	public Subject(int subjectId, String subjectName, String className) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.className = className;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", className=" + className + "]";
	}
	
	
	
	
	

}
