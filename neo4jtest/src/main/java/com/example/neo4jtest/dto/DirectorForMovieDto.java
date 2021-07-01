package com.example.neo4jtest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectorForMovieDto {
    private Long id;
    private String name;
}
