package com.infy.reactivepp.dao;

import com.infy.reactivepp.model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * Created by aditya on 21/1/18.
 */
public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
    Flux<Movie> findByTitle(String title);
}
