package org.naitech.webservices.config;


import org.naitech.logic.config.LogicConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogicConfig.class})
public class webConfig {
}
