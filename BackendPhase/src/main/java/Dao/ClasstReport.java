package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.Teacher;

public class ClasstReport {
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String GENERATE_TEACHER_REPORT = "select teacherId,teacherName,subjectName,className from teacher "
    		+ "where className = ?";

	public ClasstReport() {
		super();
	}
    
	 protected Connection getConnection() {
	    	Connection connection = null;
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    		
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    	} catch(ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return connection;
	    }
	 
	 public List<Teacher> generateReport(String className){
		 
		 List<Teacher> reportListt = new ArrayList<Teacher>();
		 
		 
		 try (Connection connection = getConnection()) {
				
			 
			 PreparedStatement preparedStatement = connection.prepareStatement(GENERATE_TEACHER_REPORT);
			 preparedStatement.setString(1,className);
			 
			 System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             
             while(rs.next()) {
            	 Teacher teacher = new Teacher();
            	 teacher.setClassName(rs.getString("className"));
            	 teacher.setTeacherId(rs.getInt("teacherId"));
            	 teacher.setTeacherName(rs.getString("teacherName"));
            	 teacher.setSubjectName(rs.getString("subjectName"));
            	 reportListt.add(teacher);
            	 
            	  }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return reportListt;
	 }
	 

}
