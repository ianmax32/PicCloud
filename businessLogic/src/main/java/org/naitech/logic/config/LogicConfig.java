package org.naitech.logic.config;


import org.naitech.translators.config.TranslatorsConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TranslatorsConfig.class})
@ComponentScan(basePackages = "org.naitech.logic")
public class LogicConfig {
}
