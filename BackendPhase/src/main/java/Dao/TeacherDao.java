package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.Teacher;

public class TeacherDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String INSERT_TEACHER_SQL = "INSERT INTO teacher" +
    "(teacherName,subjectName,className)VALUES"+"(?,?,?);";
    private static final String SELECT_TEACHER_BY_ID = "select teacherId,teacherName,subjectName,className from teacher "
    		+ "where teacherid = ?";
    private static final String SELECT_ALL_TEACHERS = "select * from teacher";
    private static final String DELETE_TEACHER_SQL = "delete from teacher where teacherId = ?;";
    private static final String UPDATE_TEACHERS_SQL = "update teacher set teacherName = ?,subjectName = ?,className = ? "
    		+ "where teacherId = ?;";
    
    public TeacherDao() {
    	
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
    
    public void insertTeacher(Teacher teacher) throws SQLException {
    	System.out.println(INSERT_TEACHER_SQL);
    	
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_SQL)) {
    		
    		preparedStatement.setString(1, teacher.getTeacherName());
    		preparedStatement.setString(2, teacher.getSubjectName());
    		preparedStatement.setString(3, teacher.getClassName());
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
 public Teacher selectTeacher(int teacherId) {
    	
    	Teacher teacher = null;
    	
    	try (Connection connection = getConnection();
    			
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID);){
    		
    		   preparedStatement.setInt(1, teacherId);
    		   System.out.println(preparedStatement);
    		   ResultSet rs = preparedStatement.executeQuery();
    		   
    		   while(rs.next()) {
    			   String teacherName = rs.getString("teacherName");
    			   String subjectName = rs.getString("subjectName");
    			   String className = rs.getString("className");
    			   teacher = new Teacher(teacherId, teacherName, subjectName, className);
    		   }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return teacher;
    	
    }
    
 public List <Teacher> selectAllTeachers(){
 	List <Teacher> teachers = new ArrayList <>();
try (Connection connection = getConnection();
 			
 			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS);){
	          
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	     		   
	     		   while(rs.next()) {
	     			   int teacherId = rs.getInt("teacherId");
	     			   String teacherName = rs.getString("teacherName");
	     			   String subjectName = rs.getString("subjectName");
	     			   String className = rs.getString("className");
	     			   teachers.add(new Teacher(teacherId, teacherName, subjectName, className));
	     			   
	     		   }
	     		   
         }catch(SQLException e) {
         	e.printStackTrace();
         }
 	
 	return teachers;
 }
 
 public boolean deleteTeacher(int teacherId) throws SQLException {
		boolean rowDeleted;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(DELETE_TEACHER_SQL);){
	
	              statement.setInt(1,teacherId);
	              rowDeleted = statement.executeUpdate()>0;
	
}
	return rowDeleted;	
	}
	
	public boolean updateTeacher(Teacher teacher) throws SQLException {
		boolean rowUpdated;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERS_SQL);){
	         
	                statement.setString(1, teacher.getTeacherName());
	                statement.setString(2, teacher.getSubjectName());
	                statement.setString(3, teacher.getClassName());
	                statement.setInt(4, teacher.getTeacherId());
	                
	                rowUpdated = statement.executeUpdate() > 0;
}

     return rowUpdated;
	                
}
	
}
