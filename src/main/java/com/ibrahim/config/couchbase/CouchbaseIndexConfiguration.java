package com.ibrahim.config.couchbase;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.manager.query.CreatePrimaryQueryIndexOptions;
import com.couchbase.client.java.manager.query.CreateQueryIndexOptions;
import com.couchbase.client.java.manager.query.QueryIndexManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class CouchbaseIndexConfiguration {

    private final Cluster couchbaseCluster;
    private final CouchbaseProperties couchbaseProperties;

    public CouchbaseIndexConfiguration(Cluster couchbaseCluster, CouchbaseProperties couchbaseProperties) {
        this.couchbaseCluster = couchbaseCluster;
        this.couchbaseProperties = couchbaseProperties;
    }

    @Bean
    public void createIndexes() {
        QueryIndexManager indexManager = couchbaseCluster.queryIndexes();

        indexManager.createPrimaryIndex(couchbaseProperties.getUserBucketName(),
                CreatePrimaryQueryIndexOptions.createPrimaryQueryIndexOptions().ignoreIfExists(Boolean.TRUE));
        try{
            couchbaseCluster.query("CREATE INDEX PRIMARY ON users");
        }
        catch (Exception e) {
            System.out.println("index error");
        }
        indexManager.createIndex(couchbaseProperties.getUserBucketName(), "users_index",
                Collections.singletonList("users"), CreateQueryIndexOptions.createQueryIndexOptions().ignoreIfExists(Boolean.TRUE));

}
}
