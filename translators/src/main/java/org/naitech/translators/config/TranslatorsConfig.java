package org.naitech.translators.config;


import org.naitech.repository.config.RepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class})
public class TranslatorsConfig {
}
