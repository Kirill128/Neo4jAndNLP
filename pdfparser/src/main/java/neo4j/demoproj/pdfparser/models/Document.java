package neo4j.demoproj.pdfparser.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @Relationship(type = "PART",direction = Relationship.Direction.INCOMING)
    private List<DataPoint> dataPoints;

    public Document(String text) {
        this.text = text;
    }


}
