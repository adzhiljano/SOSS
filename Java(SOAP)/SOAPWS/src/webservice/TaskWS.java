package webservice;

import java.util.List;

import javax.jws.WebService;

import models.Task;
import services.TaskService;
  
@WebService(endpointInterface="webservice.ITaskWS")
public class TaskWS implements ITaskWS{
	
	public TaskService TaskService;
	
	public TaskWS(){
		this.TaskService = new TaskService();
	}
  
	@Override
	public List<Task> GetTasks() {
		return this.TaskService.GetTasks();
	}
	@Override
	public Task GetTask(int taskId) throws Exception {
		return this.TaskService.GetTask(taskId);
	}
	
	@Override
	public Task CreateTask(String name, int priority, String description){
		return this.TaskService.CreateTask(name, priority, description);
	}
	
	@Override
	public Task UpdateTask(int taskId, String name, int priority, String description){
		return this.TaskService.UpdateTask(taskId, name, priority, description);	
	}
	
	@Override
	public void DeleteTask(int taskId){
		this.TaskService.DeleteTask(taskId);	
	}
}