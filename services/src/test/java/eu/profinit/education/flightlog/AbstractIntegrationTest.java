package eu.profinit.education.flightlog;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

@SpringBootTest(classes = IntegrationTestConfig.class)
@Transactional
@ActiveProfiles("inttest")
public abstract class AbstractIntegrationTest {
}