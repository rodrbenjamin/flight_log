package eu.profinit.education.flightlog;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles({"stub", "int-test"})
public abstract class IntegrationTestBase {
}