package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Task;

public class TaskService {
	
	public String url = "jdbc:sqlserver://localhost;databaseName=SOSS;integratedSecurity=true";
	
	public List<Task> GetTasks() {
		List<Task> list = new ArrayList<Task>();
		
		SetDriver();	
		
		try (Connection conn = DriverManager.getConnection(url);) {
		     
			String sql = "SELECT * FROM Tasks";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			 
			while (result.next()){
			    int taskId = result.getInt("TaskId");
			    String name = result.getString("Name");
			    int priority = result.getInt("Priority");
			    String description = result.getString("Description");
			    
			    list.add(new Task(taskId, name, priority, description));
			    
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return list;
	}
	
	public Task GetTask(int taskId) throws Exception {
		Task task = null;
		
		SetDriver();	
		
		try (Connection conn = DriverManager.getConnection(url);) {
		     
			String sql = "SELECT * FROM Tasks WHERE TaskId=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			
			ResultSet result = statement.executeQuery();
			 
			while (result.next()){
			    int fetchedTaskId = result.getInt("TaskId");
			    String fetchedName = result.getString("Name");
			    int fetchedPriority = result.getInt("Priority");
			    String fetchedDescription = result.getString("Description");
			    
			    task = new Task(fetchedTaskId, fetchedName, fetchedPriority, fetchedDescription);
			    
			    if (result.next()) {
			        throw new Exception("More than one record found");
			    }
			    
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return task;
	}
	
	public Task CreateTask(String name, int priority, String description){
		SetDriver();
		
		Task task = new Task(name, priority, description);
		
		try (Connection conn = DriverManager.getConnection(url);) {
		     
			String sql = "INSERT INTO Tasks (Name, Priority, Description) VALUES (?, ?, ?)";
			 
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, name);
			statement.setInt(2, priority);
			statement.setString(3, description);
			 
			statement.executeUpdate();
			
	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	task.setTaskId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating task failed, no ID obtained.");
	            }
	        }
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return task;
	}
	
	public Task UpdateTask(int taskId, String name, int priority, String description){
		SetDriver();
		
		try (Connection conn = DriverManager.getConnection(url);) {
			String sql = "UPDATE Tasks SET Name=?, Priority=?, Description=? WHERE TaskId=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, priority);
			statement.setString(3, description);
			statement.setInt(4, taskId);
			
			statement.executeUpdate();
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return new Task(taskId, name, priority, description);
	}
	
	public void DeleteTask(int taskId){
		SetDriver();
		
		try (Connection conn = DriverManager.getConnection(url);) {
			String sql = "DELETE FROM Tasks WHERE TaskId=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			
			statement.executeUpdate();
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	private void SetDriver(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
