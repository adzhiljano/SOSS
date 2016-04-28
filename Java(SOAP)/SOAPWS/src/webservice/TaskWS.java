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
	public Task CreateTask(Task task){
		return this.TaskService.CreateTask(task);
	}
	
	@Override
	public Task UpdateTask(int taskId, Task task){
		return this.TaskService.UpdateTask(taskId, task);	
	}
	
	@Override
	public void DeleteTask(int taskId){
		this.TaskService.DeleteTask(taskId);	
	}
}