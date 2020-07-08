package com.fundamentals_oreilly.controller;

import com.fundamentals_oreilly.entities.Greeting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName() throws Exception {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assert.assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();

        if (response != null) {
            Assert.assertEquals("Hello, world", response.getMessage());
        }
    }

    @Test
    public void greetWithName() throws Exception {
        Greeting response = template.getForObject("/rest?name=Derrick", Greeting.class);
        Assert.assertEquals("Hello, Derrick", response.getMessage());
    }


}
