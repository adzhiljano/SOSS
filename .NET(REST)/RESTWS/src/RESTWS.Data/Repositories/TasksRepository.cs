using RESTWS.DataModels;
using System;
using System.Collections.Generic;
using System.Linq;

namespace RESTWS.Data.Repositories
{
    public class TasksRepository : ITasksRepository
    {
        private MyDbContext myDbContext;
        public TasksRepository(MyDbContext myDbContext)
        {
            this.myDbContext = myDbContext;
        }

        public IEnumerable<Task> GetAll()
        {
            return myDbContext.Tasks.ToList();
        }

        public void Add(Task task)
        {
            myDbContext.Tasks.Add(task);

            myDbContext.SaveChanges();
        }

        public Task Find(int taskId)
        {
            return myDbContext.Tasks.Single(t => t.TaskId == taskId);
        }

        public Task Remove(int taskId)
        {
            var task = this.Find(taskId);

            myDbContext.Tasks.Remove(task);

            myDbContext.SaveChanges();

            return task;
        }

        public void Update(int taskId, Task task)
        {
            var oldTask = this.Find(taskId);

            oldTask.Name = task.Name;
            oldTask.Priority = task.Priority;
            oldTask.Description = task.Description;

            myDbContext.SaveChanges();
        }
    }
}
