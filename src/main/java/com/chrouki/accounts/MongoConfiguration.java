package com.chrouki.accounts;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongodb")
// Custom Mongo configuration here
@EnableMongoRepositories("com.chrouki.accounts.model")
@EnableMongoAuditing
public class MongoConfiguration {
}
