using RESTWS.DataModels;
using System;
using System.Collections.Generic;
using System.Linq;

namespace RESTWS.Data.Repositories
{
    public interface ITasksRepository
    {
        void Add(Task task);
        IEnumerable<Task> GetAll();
        Task Find(int taskId);
        Task Remove(int taskId);
        void Update(int taskId, Task item);
    }
}
