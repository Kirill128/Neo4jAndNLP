package com.example.neo4jtest.service.impl;

import com.example.neo4jtest.dao.MovieDao;
import com.example.neo4jtest.dto.MovieDto;
import com.example.neo4jtest.entities.Movie;
import com.example.neo4jtest.mapper.mapstruct.MovieMapper;
import com.example.neo4jtest.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;
    private MovieMapper movieMapper;

    public MovieServiceImpl(MovieDao movieDao, MovieMapper movieMapper) {
        this.movieDao = movieDao;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDto findByTitle(String title) {
        return this.movieMapper.mapMovieToMovieDto(this.movieDao.findByTitle(title));
    }

    @Override
    public MovieDto findById(long id) {
        return this.movieMapper.mapMovieToMovieDto(this.movieDao.findById(id).get());
    }

    @Override
    public MovieDto create(MovieDto create) {
        return this.movieMapper.mapMovieToMovieDto(
                this.movieDao.save(
                        this.movieMapper.mapMovieDtoToMovie(create)
                )
        );
    }

    @Override
    public void delete(long id) {
        this.movieDao.delete(Movie.builder().id(id).build());
    }

    @Override
    public void update(MovieDto movie) {
        this.movieDao.save(this.movieMapper.mapMovieDtoToMovie(movie));
    }

    @Override
    public List<MovieDto> findAll() {
        return this.movieMapper.mapMoviesToMovieDtos(this.movieDao.findAll());
    }
}
