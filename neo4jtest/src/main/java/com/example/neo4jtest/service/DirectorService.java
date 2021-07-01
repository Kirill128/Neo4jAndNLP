package com.example.neo4jtest.service;

import com.example.neo4jtest.dto.DirectorDto;
import com.example.neo4jtest.entities.Director;

import java.util.List;

public interface DirectorService {
    DirectorDto findByName(String name);
    List<DirectorDto> findAll();
    void create(DirectorDto director);
    void deleteByName(String name);
}
