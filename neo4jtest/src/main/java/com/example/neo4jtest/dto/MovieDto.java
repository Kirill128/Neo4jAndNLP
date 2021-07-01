package com.example.neo4jtest.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private int year;
    private List<DirectorForMovieDto> directorsDirectedBy;
}
