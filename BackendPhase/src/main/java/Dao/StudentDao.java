package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Student;

public class StudentDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String INSERT_STUDENT_SQL = "INSERT INTO student" +
    "(studentName,rollNo,className)VALUES"+"(?,?,?);";
    private static final String SELECT_STUDENT_BY_ID = "select studentId,studentName,rollno,className from student "
    		+ "where studentid = ?";
    private static final String SELECT_ALL_STUDENTS = "select * from student";
    private static final String DELETE_STUDENT_SQL = "delete from student where studentId = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update student set studentName = ?,rollNo = ?,className = ? "
    		+ "where studentId = ?;";
    
    public StudentDao() {
    	
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
    
    public void insertStudent(Student student) throws SQLException {
    	System.out.println(INSERT_STUDENT_SQL);
    	
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
    		
    		preparedStatement.setString(1, student.getStudentName());
    		preparedStatement.setInt(2, student.getRollNo());
    		preparedStatement.setString(3, student.getClassName());
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public Student selectStudent(int studentId) {
    	
    	Student student = null;
    	
    	try (Connection connection = getConnection();
    			
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);){
    		
    		   preparedStatement.setInt(1, studentId);
    		   System.out.println(preparedStatement);
    		   ResultSet rs = preparedStatement.executeQuery();
    		   
    		   while(rs.next()) {
    			   String studentName = rs.getString("studentName");
    			   int rollNo = rs.getInt("rollNo");
    			   String className = rs.getString("className");
    			   student = new Student(studentId, studentName, rollNo, className);
    			   
    		   }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return student;
    	
    }
    
    
    public List <Student> selectAllStudents(){
    	List <Student> students = new ArrayList <>();
try (Connection connection = getConnection();
    			
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);){
	          
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	     		   
	     		   while(rs.next()) {
	     			   int studentId = rs.getInt("studentId");
	     			   String studentName = rs.getString("studentName");
	     			   int rollNo = rs.getInt("rollNo");
	     			   String className = rs.getString("className");
	     			   students.add(new Student(studentId, studentName, rollNo, className));
	     			   
	     			   
	     		   }
	     		   
            }catch(SQLException e) {
            	e.printStackTrace();
            }
    	
    	return  students;
    }
    
	public boolean deleteStudent(int studentId) throws SQLException {
		boolean rowDeleted;
try (Connection connection = getConnection();
    			
    			PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);){
	
	              statement.setInt(1, studentId);
	              rowDeleted = statement.executeUpdate()>0;
	              
	
}
	return rowDeleted;	
	}
	
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
try (Connection connection = getConnection();
    			
    			PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);){
	         
	                statement.setString(1, student.getStudentName());
	                statement.setInt(2, student.getRollNo());
	                statement.setString(3, student.getClassName());
	                statement.setInt(4, student.getStudentId());
	                rowUpdated = statement.executeUpdate() > 0;
	                
}

        return rowUpdated;
	                
}
	
	
}
