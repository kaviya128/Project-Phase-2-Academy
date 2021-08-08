package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Classes;


public class ClassesDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/collegemanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword ="Rakav2117#";
    
    private static final String INSERT_CLASSES_SQL = "INSERT INTO classes" +
    "(className,classSection)VALUES"+"(?,?);";
    private static final String SELECT_CLASSES_BY_ID = "select classId,className,classSection from classes "
    		+ "where classId = ?";
    private static final String SELECT_ALL_CLASSES = "select * from classes";
    private static final String DELETE_CLASSES_SQL = "delete from classes where classId = ?;";
    private static final String UPDATE_CLASSES_SQL = "update classes set className = ?,classSection = ? "
    		+ "where classId = ?;";
   
    
    public ClassesDao() {
    	
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
    
    
    public void insertClasses(Classes classes) throws SQLException {
    	System.out.println(INSERT_CLASSES_SQL);
    	
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASSES_SQL)) {
    		
    		preparedStatement.setString(1, classes.getClassName());
    		preparedStatement.setString(2, classes.getClassSection());
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
 public Classes selectClasses(int classId) {
    	
    	Classes classes = null;
    	
    	try (Connection connection = getConnection();
    			
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSES_BY_ID);){
    		
    		   preparedStatement.setInt(1, classId);
    		   System.out.println(preparedStatement);
    		   ResultSet rs = preparedStatement.executeQuery();
    		   
    		   while(rs.next()) {
    			   String className = rs.getString("className");
    			   String classSection = rs.getString("classSection");
    			   classes = new Classes(classId, className, classSection);
    		   }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return classes;
    	
    }
 
 public List <Classes> selectAllClasses(){
 	List <Classes> classes = new ArrayList <>();
try (Connection connection = getConnection();
 			
 			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSES);){
	          
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	     		   
	     		   while(rs.next()) {
	     			   int classId = rs.getInt("classId");
	     			   String className = rs.getString("className");
	     			    String classSection = rs.getString("classSection");
	     			   classes.add(new Classes(classId, className, classSection));
	     			   
	     		   }
	     		   
         }catch(SQLException e) {
         	e.printStackTrace();
         }
 	
 	return classes;
 }
 
 public boolean deleteClasses(int classId) throws SQLException {
		boolean rowDeleted;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(DELETE_CLASSES_SQL);){
	
	              statement.setInt(1,classId);
	              rowDeleted = statement.executeUpdate()>0;
	
}
	return rowDeleted;	
	}
	
	public boolean updateClasses(Classes classes) throws SQLException {
		boolean rowUpdated;
try (Connection connection = getConnection();
 			
 			PreparedStatement statement = connection.prepareStatement(UPDATE_CLASSES_SQL);){
	         
	                statement.setString(1, classes.getClassName());
	                statement.setString(2, classes.getClassSection());
	                statement.setInt(3, classes.getClassId());
	                
	                rowUpdated = statement.executeUpdate() > 0;
}

     return rowUpdated;
	                
}
	
	
	
	
 
}
