package com.example.neo4jtest.dao;

import com.example.neo4jtest.entities.Director;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DirectorDao extends Neo4jRepository<Director,Long> {
    Director findByName(String name);
}
