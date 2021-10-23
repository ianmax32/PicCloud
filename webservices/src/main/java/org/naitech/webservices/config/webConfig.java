package org.naitech.webservices.config;


import org.naitech.logic.config.LogicConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogicConfig.class})
@ComponentScan(basePackages = "org.naitech.webservices.controllers")
public class webConfig {
}
