package com.example.restcucumber.steps;

import com.example.restcucumber.RestCucumberApplication;
import com.example.restcucumber.controllers.AvengersController;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = RestCucumberApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public abstract class SpringIntegrationTest {

    protected RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    public int getPort() {
        return port;
    }
}
