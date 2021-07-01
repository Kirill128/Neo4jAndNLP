package com.example.neo4jtest.mapper.mapstruct;

import com.example.neo4jtest.dto.DirectorDto;
import com.example.neo4jtest.dto.DirectorForMovieDto;
import com.example.neo4jtest.entities.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper INSTANCE= Mappers.getMapper(DirectorMapper.class);

    DirectorDto mapDirectorToDirectorDto(Director source);
    List<DirectorDto> mapDirectorToDirectorDto(List<Director> source);
    DirectorForMovieDto mapDirectorToDirectorForMovieDto(Director source);
    List<DirectorForMovieDto> mapDirectorsToDirectorForMovieDtos(List<Director> source);
    Director mapDirectorDtoToDirector(DirectorDto director);

}
