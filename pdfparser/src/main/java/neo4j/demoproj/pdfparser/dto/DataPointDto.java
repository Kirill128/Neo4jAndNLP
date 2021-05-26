package neo4j.demoproj.pdfparser.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataPointDto {
    private Long id;
    private String key;
    private String text;
}
