package com.example.neo4jtest.rest;

import com.example.neo4jtest.dto.MovieDto;
import com.example.neo4jtest.entities.Movie;
import com.example.neo4jtest.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<MovieDto> findAll(){
        return this.movieService.findAll();
    }
    @GetMapping("/{title}")
    public MovieDto findByTitle(@PathVariable String title){
        return this.movieService.findByTitle(title);
    }
}
