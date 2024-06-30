package com.apidemo.productservice.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(basePackages = "com.apidemo.productservice.repositories.jpa")
public class JpaRepoConfig {
}
