package models;

public class Classes {
	protected int classId;
	protected String className;
	protected String classSection;
	
	public Classes() {
		super();
	}

	public Classes(String className, String classSection) {
		super();
		this.className = className;
		this.classSection = classSection;
	}

	public Classes(int classId, String className, String classSection) {
		super();
		this.classId = classId;
		this.className = className;
		this.classSection = classSection;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", classSection=" + classSection + "]";
	}
	
	
	
	

}
