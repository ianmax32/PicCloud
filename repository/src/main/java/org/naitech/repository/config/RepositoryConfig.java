package org.naitech.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.naitech.domain.persistence")
@EnableJpaRepositories(basePackages = "org.naitech.repository")
@PropertySource(value = "classpath:applicationrepository.properties")
public class RepositoryConfig {
}
