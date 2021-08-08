package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.Subject;

public class SubjectDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String INSERT_SUBJECT_SQL = "INSERT INTO subject" +
    "(subjectName,className)VALUES"+"(?,?);";
    private static final String SELECT_SUBJECT_BY_ID = "select subjectId,subjectName,className from subject "
    		+ "where subjectId = ?";
    private static final String SELECT_ALL_SUBJECTS = "select * from subject";
    private static final String DELETE_SUBJECT_SQL = "delete from subject where subjectId = ?;";
    private static final String UPDATE_SUBJECT_SQL = "update subject set subjectName = ?,className = ? "
    		+ "where subjectId = ?;";
    
    public SubjectDao() {
    	
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
    
    public void insertSubject(Subject subject) throws SQLException {
    	System.out.println(INSERT_SUBJECT_SQL);
    	
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUBJECT_SQL)) {
    		
    		preparedStatement.setString(1, subject.getSubjectName());
    		preparedStatement.setString(2, subject.getClassName());
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
 public Subject selectSubject(int subjectId) {
    	
    	Subject subject = null;
    	
    	try (Connection connection = getConnection();
    			
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUBJECT_BY_ID);){
    		
    		   preparedStatement.setInt(1, subjectId);
    		   System.out.println(preparedStatement);
    		   ResultSet rs = preparedStatement.executeQuery();
    		   
    		   while(rs.next()) {
    			   String subjectName = rs.getString("subjectName");
    			   String className = rs.getString("className");
    			   subject = new Subject(subjectId, subjectName,className);
    		   }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return subject;
    	
    }
 
 public List <Subject> selectAllSubjects(){
 	List <Subject> subjects = new ArrayList <>();
try (Connection connection = getConnection();
 			
 			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUBJECTS);){
	          
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	     		   
	     		   while(rs.next()) {
	     			   int subjectId = rs.getInt("subjectId");
	     			   String subjectName = rs.getString("subjectName");
	     			   String className = rs.getString("className");
	     			   subjects.add(new Subject(subjectId, subjectName,className));
	     			   
	     		   }
	     		   
         }catch(SQLException e) {
         	e.printStackTrace();
         }
 	
 	return  subjects;
 }
 
 public boolean deleteSubject(int subjectId) throws SQLException {
		boolean rowDeleted;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(DELETE_SUBJECT_SQL);){
	
	              statement.setInt(1, subjectId);
	              rowDeleted = statement.executeUpdate()>0;
	
}
	return rowDeleted;	
	}
	
	public boolean updateSubject(Subject subject) throws SQLException {
		boolean rowUpdated;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(UPDATE_SUBJECT_SQL);){
	         
	                statement.setString(1, subject.getSubjectName());
	                statement.setString(2, subject.getClassName());
	                statement.setInt(3, subject.getSubjectId());
	                
	                rowUpdated = statement.executeUpdate() > 0;
}

     return rowUpdated;
	                
}
	
 
    
    

}
