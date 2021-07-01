package com.example.neo4jtest.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectorDto {
    private Long id;
    private String name;
    private List<MovieForDirectorDto> moviesActedIn;
}
