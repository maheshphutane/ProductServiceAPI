package com.apidemo.productservice.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.apidemo.productservice.repositories.elasticsearch")
public class ElasticSearchRepoConfig {
}
