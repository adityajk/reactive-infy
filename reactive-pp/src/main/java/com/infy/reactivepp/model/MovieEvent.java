package com.infy.reactivepp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by aditya on 21/1/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {
    private String movieId;
    private Date when;;
}
