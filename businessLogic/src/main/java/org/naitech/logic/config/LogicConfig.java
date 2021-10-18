package org.naitech.logic.config;


import org.naitech.translators.config.TranslatorsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TranslatorsConfig.class})
public class LogicConfig {
}
