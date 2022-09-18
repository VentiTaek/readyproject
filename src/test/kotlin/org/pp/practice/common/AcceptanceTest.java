package org.pp.practice.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import io.restassured.RestAssured;

@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {

    @LocalServerPort
    protected int port;

    @Autowired
    private DatabaseCleanUp databaseCleanUp;


    @BeforeEach
    void setUp() {
        RestAssured.port = this.port;
        // RestAssured.config().objectMapperConfig(RestAssured.config()
        //     .objectMapperConfig(new ObjectMapperConfig((ObjectMapper)new ObjectMapperConfig(ObjectMapperType.GSON)))
    }

    @AfterEach
    void cleanUpDatabase() {
        databaseCleanUp.execute();

    }
}
