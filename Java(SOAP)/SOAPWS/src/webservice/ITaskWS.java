package webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style;
import models.Task;  
  
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ITaskWS {  
	@WebMethod public List<Task> GetTasks();
	
	@WebMethod public Task GetTask(
			@WebParam(name = "taskId", targetNamespace="http://webservice/") int taskId) throws Exception;
	
	@WebMethod public Task CreateTask(
			@WebParam(name = "name", targetNamespace="http://webservice/") String name,
			@WebParam(name = "priority", targetNamespace="http://webservice/") int priority,
			@WebParam(name = "description", targetNamespace="http://webservice/") String description);
	
	@WebMethod public Task UpdateTask(
			@WebParam(name = "taskId", targetNamespace="http://webservice/") int taskId, 
			@WebParam(name = "name", targetNamespace="http://webservice/") String name,
			@WebParam(name = "priority", targetNamespace="http://webservice/") int priority,
			@WebParam(name = "description", targetNamespace="http://webservice/") String description);
	
	@WebMethod public void DeleteTask(
			@WebParam(name = "taskId", targetNamespace="http://webservice/") int taskId);
}