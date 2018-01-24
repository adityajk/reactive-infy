package com.infy.reactivepp.dao;

import com.infy.reactivepp.model.Movie;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

/**
 * Created by aditya on 21/1/18.
 */
@Component
public class DataLoader {
    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    private void loadData() {
        this.movieRepository.deleteAll().thenMany(
                Flux.just("Enter the Mono<Void>",
                        "Y Tu Mono También",
                        "Meet the Fluxers")
                        .map(Movie::new)
                        .flatMap(this.movieRepository::save))
                .subscribe(System.out::println);


    }
}