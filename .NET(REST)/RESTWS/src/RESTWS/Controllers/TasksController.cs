using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNet.Mvc;
using RESTWS.Data.Repositories;
using RESTWS.DataModels;

namespace RESTWS.Controllers
{
    [Route("api/[controller]")]
    public class TasksController : Controller
    {
        private ITasksRepository tasksRepository;
        public TasksController(ITasksRepository tasksRepository)
        {
            this.tasksRepository = tasksRepository;
        }

        // GET: api/tasks
        [HttpGet]
        public IEnumerable<Task> Get()
        {
            return this.tasksRepository.GetAll();
        }

        // GET api/tasks/5
        [HttpGet("{id}")]
        public Task Get(int id)
        {
            return this.tasksRepository.Find(id);
        }

        // POST api/tasks
        [HttpPost]
        public void Post(Task task)
        {
            this.tasksRepository.Add(task);
        }

        // PUT api/tasks/5
        [HttpPut("{id}")]
        public void Put(int id, Task task)
        {
            this.tasksRepository.Update(id, task);
        }

        // DELETE api/tasks/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            this.tasksRepository.Remove(id);
        }
    }
}
