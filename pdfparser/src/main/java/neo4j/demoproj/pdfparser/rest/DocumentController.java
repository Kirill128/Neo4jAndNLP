package neo4j.demoproj.pdfparser.rest;

import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.exceptions.NoSuchDocumentException;
import neo4j.demoproj.pdfparser.services.DocumentService;
import org.apache.tika.exception.TikaException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/{documentId}/data-points")
    public List<DataPointDto> getDocumentDataPointsByDocumentId(@PathVariable int documentId)throws NoSuchDocumentException {
        return this.documentService.getDocumentById(documentId).getDataPoints();
    }

    @GetMapping("/{documentId}")
    public List<DataPointDto> findParagraphsWithTitle(@PathVariable long documentId,
                                                      @RequestParam("title") String title) throws NoSuchDocumentException {
        return this.documentService.findDocumentDataPointsOfParagraphsWithTitle(documentId,title);
    }

    @PostMapping(value = "/load",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String loadDocument(@RequestPart("pdffile") MultipartFile file) throws TikaException,IOException, SAXException {
        this.documentService.addDocumentToDb(file);
        return "Document Successfully loaded!!";
    }

}
