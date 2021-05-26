package neo4j.demoproj.pdfparser.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("DataPoint")
public class DataPoint {
    @Id
    @GeneratedValue
    private Long id;
    private String key;
    private String text;

    public DataPoint(String key, String text) {
        this.key = key;
        this.text = text;
    }

}
