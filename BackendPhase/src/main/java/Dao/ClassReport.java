package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.Student;



public class ClassReport {
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String GENERATE_STUDENT_REPORT = "select studentId,studentName,rollno,className from student "
    		+ "where className = ?";
  
      
	public ClassReport() {
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
	 
	 public List<Student> generateReport(String className){
		 
		 List<Student> reportList = new ArrayList<Student>();
		 
		 
		 try (Connection connection = getConnection()) {
				
			 
			 PreparedStatement preparedStatement = connection.prepareStatement(GENERATE_STUDENT_REPORT);
			 preparedStatement.setString(1,className);
			 
			 System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             
             while(rs.next()) {
            	 Student student = new Student();
            	 student.setClassName(rs.getString("className"));
            	 student.setStudentId(rs.getInt("studentId"));
            	 student.setStudentName(rs.getString("studentName"));
            	 student.setRollNo(rs.getInt("rollNo"));
            	 reportList.add(student);
            	 
            	  }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return reportList;
	 }
	 
             
		
 }
    


