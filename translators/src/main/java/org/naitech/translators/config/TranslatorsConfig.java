package org.naitech.translators.config;


import org.naitech.repository.config.RepositoryConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class})
@ComponentScan(basePackages = "org.naitech.translators")
public class TranslatorsConfig {
}
