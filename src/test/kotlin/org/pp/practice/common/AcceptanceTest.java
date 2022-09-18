package org.pp.practice.common;

import java.lang.reflect.Type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.module.kotlin.KotlinModule;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;

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
