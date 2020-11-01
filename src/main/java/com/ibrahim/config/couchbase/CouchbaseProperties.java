package com.ibrahim.config.couchbase;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "couchbase")
public class CouchbaseProperties {
    private String host;
    private String userName;
    private String password;
    private String userBucketName;
    private String taskBucketName;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserBucketName() {
        return userBucketName;
    }

    public void setUserBucketName(String userBucketName) {
        this.userBucketName = userBucketName;
    }

    public String getTaskBucketName() {
        return taskBucketName;
    }

    public void setTaskBucketName(String taskBucketName) {
        this.taskBucketName = taskBucketName;
    }
}