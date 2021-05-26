package neo4j.demoproj.pdfparser.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDto {
    private Long id;
    private List<DataPointDto> dataPoints;
}
