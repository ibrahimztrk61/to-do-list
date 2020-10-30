package com.ibrahim.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.ibrahim.dto.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Cluster couchbaseCluster;
    private final Collection userCollection;

    public UserRepository(Cluster cluster, Collection collection) {
        this.couchbaseCluster = cluster;
        this.userCollection = collection;
    }

    public void saveUser(UserDto userDto) {
        userCollection.insert(userDto.getId(),userDto);
    }
}
