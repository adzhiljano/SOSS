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
			    
			    list.add(new Task(taskId, name));
			    
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
			    
			    task = new Task(fetchedTaskId, fetchedName);
			    
			    if (result.next()) {
			        throw new Exception("More than one record found");
			    }
			    
			}
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return task;
	}
	
	public Task CreateTask(Task task){
		SetDriver();
		
		try (Connection conn = DriverManager.getConnection(url);) {
		     
			String sql = "INSERT INTO Tasks (Name) VALUES (?)";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, task.Name);
			 
			statement.executeUpdate();
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return task;
	}
	
	public Task UpdateTask(int taskId, Task task){
		SetDriver();
		
		try (Connection conn = DriverManager.getConnection(url);) {
			String sql = "UPDATE Tasks SET Name=? WHERE TaskId=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, task.Name);
			statement.setInt(2, taskId);
			
			statement.executeUpdate();
		     
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		return task;
	}
	
	public void DeleteTask(int taskId){
		SetDriver();
		
		try (Connection conn = DriverManager.getConnection(url);) {
			String sql = "DELETE FROM Tasks WHERE TaskId=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(2, taskId);
			
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
