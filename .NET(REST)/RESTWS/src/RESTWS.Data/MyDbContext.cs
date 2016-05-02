using Microsoft.Data.Entity;
using RESTWS.DataModels;
using System;
using System.Collections.Generic;
using System.Linq;

namespace RESTWS.Data
{
    public partial class MyDbContext : DbContext
    {
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Task>(entity =>
            {
                entity.ToTable("Tasks");

                entity.Property(e => e.TaskId).IsRequired();
                entity.Property(e => e.Name).IsRequired();
                entity.Property(e => e.Priority).IsRequired();
                entity.Property(e => e.Description).IsRequired();
            });
        }

        public virtual DbSet<Task> Tasks { get; set; }
    }
}
