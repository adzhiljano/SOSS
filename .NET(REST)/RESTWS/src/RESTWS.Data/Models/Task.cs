using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace RESTWS.DataModels
{
    public class Task
    {
        public int TaskId { get; set; }
        public string Name { get; set; }
        public int Priority { get; set; }
        public string Description { get; set; }

        public Task()
        {
        }
    }
}
