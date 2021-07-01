package com.example.neo4jtest.mapper.own;

import com.example.neo4jtest.dto.MovieDto;
import com.example.neo4jtest.entities.Movie;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {
    public Movie mapMovieDtoToMovie(MovieDto source){
        return Movie.builder().build();
    }
    public MovieDto mapMovieDtoToMovie(Movie source){
        return MovieDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .year(source.getYear())
//                .directorsDirected(source.getDirectorsDirectedBy())
                .build();
    }

    public List<MovieDto> mapMovieDtosToMovies(List<Movie> source){
        return source.stream().map(MovieMapper::mapMovieDtoToMovie).collect(Collectors.toList());
    }



}
