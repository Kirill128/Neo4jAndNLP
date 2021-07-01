package com.example.neo4jtest.mapper.mapstruct;

import com.example.neo4jtest.dto.MovieDto;
import com.example.neo4jtest.dto.MovieForDirectorDto;
import com.example.neo4jtest.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE= Mappers.getMapper(MovieMapper.class);

    MovieDto mapMovieToMovieDto(Movie source);
    List<MovieDto> mapMoviesToMovieDtos(List<Movie> source);
    MovieForDirectorDto mapMovieToMovieForDirectorDto(Movie source);
    List<MovieForDirectorDto> mapMoviesToMovieForDirectorDtos(List<Movie> source);
    Movie mapMovieDtoToMovie(MovieDto create);
}
