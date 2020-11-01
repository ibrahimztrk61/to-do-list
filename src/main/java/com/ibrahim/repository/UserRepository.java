package com.ibrahim.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.ibrahim.dto.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Cluster couchbaseCluster;
    private final Collection userCollection;

    public UserRepository(Cluster cluster, @Qualifier("userCollection") Collection userCollection) {
        this.couchbaseCluster = cluster;
        this.userCollection = userCollection;
    }

    public void saveUser(UserDto userDto) {
        userCollection.insert(userDto.getId(),userDto);
    }
}
