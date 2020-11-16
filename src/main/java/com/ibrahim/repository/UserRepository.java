package com.ibrahim.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.ibrahim.dtos.TaskDto;
import com.ibrahim.dtos.UserDto;
import com.ibrahim.entities.TaskStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final Cluster couchbaseCluster;
    private final Collection userCollection;

    public UserRepository(Cluster cluster, Collection userCollection) {
        this.couchbaseCluster = cluster;
        this.userCollection = userCollection;
    }

    public void saveUser(UserDto userDto) {
        userCollection.insert(userDto.getId(), userDto);
    }

    public List<UserDto> getAllUsers() {
        String statement = "Select name from users";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(UserDto.class);
    }

    public UserDto findUserById(String userId) {
        GetResult result = userCollection.get(userId);
        UserDto userDto = result.contentAs(UserDto.class);
        return userDto;
    }

    public void deleteUser(String userId) {
        userCollection.remove(userId);
    }

    public void deleteTask(String taskId) {
        userCollection.remove(taskId);
    }

    public List<UserDto> getUserByName(String userName) {
        return null;
    }

    public void createTask(TaskDto taskDto) {
        userCollection.insert(taskDto.getUserId(),taskDto);
    }

    public void changeTaskStatus(String taskId, TaskStatus taskStatus) {
        String statement = String.format("UPDATE `users` USE KEYS %s SET `status`= %s",taskId,taskStatus);
        QueryResult query = couchbaseCluster.query(statement);
        query.rowsAsObject();
    }

    public void updateTask(TaskDto taskDto) {
        userCollection.replace(taskDto.getId(),taskDto);
    }
}
