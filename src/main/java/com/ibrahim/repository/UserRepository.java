package com.ibrahim.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.query.QueryResult;
import com.ibrahim.dto.UserDto;
import com.ibrahim.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
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
        userCollection.insert(userDto.getId(),userDto);
    }

    public List<UserDto> findAllUsers() {
        String statement = "Select name from users";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(UserDto.class);

    }
}
