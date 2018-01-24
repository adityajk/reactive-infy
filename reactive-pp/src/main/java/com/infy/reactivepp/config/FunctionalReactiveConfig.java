package com.infy.reactivepp.config;

import com.infy.reactivepp.model.Movie;
import com.infy.reactivepp.model.MovieEvent;
import com.infy.reactivepp.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by aditya on 21/1/18.
 */
@Configuration
public class FunctionalReactiveConfig {

    @Bean
    RouterFunction<?> routerFunction(MovieService movieService) {
        return route(
                GET("/movies"), request -> ServerResponse
                        .ok()
                        .body(movieService.getAllMovies(), Movie.class))
                .andRoute(
                        GET("/movies/{id}"), request -> ServerResponse
                                .ok()
                                .body(movieService.getMovieById(request.pathVariable("id")), Movie.class))
                .andRoute(
                        GET("/movies/{id}/events"), request -> ServerResponse
                                .ok()
                                .contentType(MediaType.TEXT_EVENT_STREAM)
                                .body(movieService.geEvents(request.pathVariable("id")), MovieEvent.class));
    }
}
