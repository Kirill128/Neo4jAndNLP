package com.example.neo4jtest.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int year;
    @Relationship(type = "DIRECTED",direction = Relationship.Direction.OUTGOING)
    private List<Director> directorsDirectedBy=new ArrayList<>();
    
}
