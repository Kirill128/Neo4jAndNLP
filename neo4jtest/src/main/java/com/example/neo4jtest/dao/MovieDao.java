package com.example.neo4jtest.dao;

import com.example.neo4jtest.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieDao extends Neo4jRepository<Movie,Long> {
    Movie findByTitle(String title);
}
