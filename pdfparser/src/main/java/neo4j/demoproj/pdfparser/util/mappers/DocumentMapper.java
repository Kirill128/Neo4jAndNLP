package neo4j.demoproj.pdfparser.util.mappers;

import lombok.experimental.UtilityClass;
import neo4j.demoproj.pdfparser.dto.DocumentDto;
import neo4j.demoproj.pdfparser.models.Document;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DocumentMapper {
    public DocumentDto mapDocumentToDocumentDto(Document document){
        return DocumentDto.builder()
                .id(document.getId())
                .dataPoints(
                        DataPointMapper.mapDataPointsToDataPointDtos(document.getDataPoints())
                )
                .build();
    }
    public List<DocumentDto> mapDocumentsToDocumentDtos(List<Document> documents){
        return documents.stream().map(DocumentMapper::mapDocumentToDocumentDto).collect(Collectors.toList());
    }
    public Document mapDocumentDtoToDocument(DocumentDto document){
        return Document.builder()
                .id(document.getId())
                .dataPoints(
                        DataPointMapper.mapDataPointDtosToDataPoints(document.getDataPoints())
                )
                .build();
    }
    public List<Document> mapDocumentDtosToDocuments(List<DocumentDto> documents){
        return documents.stream().map(DocumentMapper::mapDocumentDtoToDocument).collect(Collectors.toList());
    }
}
