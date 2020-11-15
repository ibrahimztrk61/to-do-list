package com.ibrahim.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.query.QueryResult;
import com.ibrahim.dtos.TaskDto;
import com.ibrahim.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {


    private final Cluster couchbaseCluster;
    private final Collection taskCollection;

    public TaskRepository(Cluster couchbaseCluster,Collection taskCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.taskCollection = taskCollection;
    }

    public void save(TaskDto taskDto) {
        taskCollection.insert(taskDto.getId(), taskDto);
    }

    public TaskDto getByKey(String key){
        return taskCollection.get(key).contentAs(TaskDto.class);
    }

    public List<Task> findAllTasks() {
        String statement = "SELECT category, description, taskStatus, duration FROM Task";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Task.class);
    }
}
