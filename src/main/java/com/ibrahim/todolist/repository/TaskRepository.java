package com.ibrahim.todolist.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.ibrahim.todolist.entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {


    private final Cluster couchbaseCluster;
    private final Collection taskCollection;

    public TaskRepository(Cluster couchbaseCluster, Collection taskCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.taskCollection = taskCollection;
    }

    public void save(Task task) {
        taskCollection.insert(task.getId(),task);
    }
}
