package com.ibrahim.config.couchbase;

import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.codec.JacksonJsonSerializer;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.json.JsonValueModule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.Duration;

@Configuration
public class ToDoListCouchbaseConfiguration {

    private final CouchbaseProperties couchbaseProperties;

    public ToDoListCouchbaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

    @Bean
    public Cluster couchbaseCluster() {
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder()
                .modules(new JsonValueModule())
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ClusterEnvironment clusterEnvironment = ClusterEnvironment.builder()
                .jsonSerializer(JacksonJsonSerializer.create(mapper))
                .timeoutConfig(TimeoutConfig
                        .connectTimeout(Duration.ofSeconds(12))
                        .searchTimeout(Duration.ofSeconds(12))
                        .managementTimeout(Duration.ofSeconds(12))
                        .queryTimeout(Duration.ofSeconds(12)))
                .build();

        return Cluster.connect(couchbaseProperties.getHost(), ClusterOptions
                .clusterOptions(couchbaseProperties.getUserName(), couchbaseProperties.getPassword())
                .environment(clusterEnvironment));
    }

    @Bean
    public Collection userCollection(Cluster couchbaseCluster) {
        Bucket bucket = couchbaseCluster.bucket(couchbaseProperties.getUserBucketName());
        bucket.waitUntilReady(Duration.ofSeconds(122));
        return bucket.defaultCollection();
    }
    @Bean
    public Collection taskCollection(Cluster couchbaseCluster) {
        Bucket bucket = couchbaseCluster.bucket(couchbaseProperties.getTaskBucketName());
        bucket.waitUntilReady(Duration.ofSeconds(122));
        return bucket.defaultCollection();
    }

}