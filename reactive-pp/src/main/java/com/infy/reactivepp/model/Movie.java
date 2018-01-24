package com.infy.reactivepp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by aditya on 21/1/18.
 */
@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    private String id;
    @NonNull
    private String title;
}
