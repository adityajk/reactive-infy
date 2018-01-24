package com.infy.reactivepp.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest extends TestCase {

    @Autowired
    private MovieService movieService;

    @Test
    public void testGeEventsTake10() throws Exception {
        String movieId = movieService.getAllMovies().blockFirst().getId();

        StepVerifier.withVirtualTime(() -> movieService.geEvents(movieId).take(10))
                .thenAwait(Duration.ofHours(10))
                .expectNextCount(10)
                .verifyComplete();
    }
}