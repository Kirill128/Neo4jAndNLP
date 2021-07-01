package com.example.neo4jtest.service;

import com.example.neo4jtest.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto findByTitle(String title);
    MovieDto findById(long id);
    MovieDto create(MovieDto create);
    void delete(long id );
    void update (MovieDto movie);
    List<MovieDto> findAll();
}
