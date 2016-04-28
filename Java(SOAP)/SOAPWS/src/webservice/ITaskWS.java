package webservice;

import java.util.List;
import javax.jws.WebMethod;  
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style;
import models.Task;  
  
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ITaskWS {  
	@WebMethod public List<Task> GetTasks();
	
	@WebMethod public Task GetTask(int taskId) throws Exception;
	
	@WebMethod public Task CreateTask(Task task);
	
	@WebMethod public Task UpdateTask(int taskId, Task task);
	
	@WebMethod public void DeleteTask(int taskId);
}