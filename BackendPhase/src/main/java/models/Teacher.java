package models;

public class Teacher {
	protected int teacherId;
	protected String teacherName;
	protected String subjectName;
	protected String className;
	public Teacher() {
		super();
	}
	public Teacher(String teacherName, String subjectName, String className) {
		super();
		this.teacherName = teacherName;
		this.subjectName = subjectName;
		this.className = className;
	}
	public Teacher(int teacherId, String teacherName, String subjectName, String className) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
		this.className = className;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", subjectName=" + subjectName
				+ ", className=" + className + "]";
	}
	
	

}
