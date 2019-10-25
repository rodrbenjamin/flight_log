package eu.profinit.education.flightlog;

import eu.profinit.education.flightlog.domain.DomainConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DomainConfig.class)
@ComponentScan
@EnableAutoConfiguration
public class IntegrationTestConfig {
}
