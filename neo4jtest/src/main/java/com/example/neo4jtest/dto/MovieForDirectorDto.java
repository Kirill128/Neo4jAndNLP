package com.example.neo4jtest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieForDirectorDto {
    private Long id;
    private String name;
    private int year;

}
