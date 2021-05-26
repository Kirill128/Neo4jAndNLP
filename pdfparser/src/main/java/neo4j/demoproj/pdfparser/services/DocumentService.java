package neo4j.demoproj.pdfparser.services;

import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.dto.DocumentDto;
import neo4j.demoproj.pdfparser.exceptions.NoSuchDocumentException;
import org.apache.tika.exception.TikaException;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    DocumentDto getDocumentById(long id) throws NoSuchDocumentException;
    void addDocumentToDb(MultipartFile file) throws TikaException, IOException, SAXException;
    List<DataPointDto> findDocumentDataPointsOfParagraphsWithTitle(long documentId,String title) throws NoSuchDocumentException;
}
