package models;

import java.io.Serializable;

public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int TaskId;
	private String Name;
	private int Priority;
	private String Description;

	public Task() {}

	public Task(String name, int priority, String description){
		this.Name = name;
		this.Priority = priority;
		this.Description = description;
	}
	
	public Task(int taskId, String name, int priority, String description){
		this.TaskId = taskId;
		this.Name = name;
		this.Priority = priority;
		this.Description = description;
	}
	
	public int getTaskId() {
		return TaskId;
	}

	public void setTaskId(int taskId) {
		TaskId = taskId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
