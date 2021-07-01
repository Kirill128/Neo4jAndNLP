package com.example.neo4jtest.service.impl;

import com.example.neo4jtest.dao.DirectorDao;
import com.example.neo4jtest.dto.DirectorDto;
import com.example.neo4jtest.mapper.mapstruct.DirectorMapper;
import com.example.neo4jtest.service.DirectorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {
    private DirectorDao directorDao;
    private DirectorMapper directorMapper;

    public DirectorServiceImpl(DirectorDao directorDao, DirectorMapper directorMapper) {
        this.directorDao = directorDao;
        this.directorMapper = directorMapper;
    }

    @Override
    public DirectorDto findByName(String name) {
        return this.directorMapper.mapDirectorToDirectorDto(this.directorDao.findByName(name));
    }

    @Override
    public List<DirectorDto> findAll() {
        return this.directorMapper.mapDirectorToDirectorDto(this.directorDao.findAll());
    }

    @Override
    public void create(DirectorDto director) {
        this.directorDao.save(directorMapper.mapDirectorDtoToDirector(director));
    }

    @Override
    public void deleteByName(String name) {
        this.deleteByName(name);
    }
}
