package com.chrouki.accounts;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("jpa")
// Custom JPA configuration here
@EnableJpaRepositories("com.chrouki.accounts.model")
@EnableJpaAuditing
public class JpaConfiguration {
}
