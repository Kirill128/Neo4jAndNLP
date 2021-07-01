package com.example.neo4jtest.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node
public class Director {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Movie> moviesDirected;
    @Relationship(type="ACTED_IN",direction = Relationship.Direction.OUTGOING)
    private List<Movie> moviesActedIn;
}
