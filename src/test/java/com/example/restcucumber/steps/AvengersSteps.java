package com.example.restcucumber.steps;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

public class AvengersSteps  extends SpringIntegrationTest {

    @Entao("^should return all avengers$")
    public void shouldReturnAllAvengers() throws URISyntaxException {
        final String url = "http://localhost:" + this.getPort() + "/avengers";
        final ResponseEntity<List<String>> response = this.restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>(){});
        Assert.assertEquals(200, response.getStatusCode().value());
        Assert.assertEquals(6, response.getBody().size());
    }

    @Entao("^should return one avenger name \"([^\"]*)\"$")
    public void shouldReturnOneAvenger(String name) throws URISyntaxException {
        String url = "http://localhost:" + this.getPort() + "/avengers/{name}";
        final ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class,
                name
        );
        Assert.assertEquals(200, response.getStatusCode().value());
        Assert.assertEquals(name, response.getBody());
    }

}
