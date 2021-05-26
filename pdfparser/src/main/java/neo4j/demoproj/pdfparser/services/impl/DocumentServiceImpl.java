package neo4j.demoproj.pdfparser.services.impl;

import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.dto.DocumentDto;
import neo4j.demoproj.pdfparser.exceptions.NoSuchDocumentException;
import neo4j.demoproj.pdfparser.models.DataPoint;
import neo4j.demoproj.pdfparser.models.Document;
import neo4j.demoproj.pdfparser.repositories.DataPointDao;
import neo4j.demoproj.pdfparser.repositories.DocumentDao;
import neo4j.demoproj.pdfparser.services.DocumentService;
import neo4j.demoproj.pdfparser.util.PDFWorker;
import neo4j.demoproj.pdfparser.util.mappers.DataPointMapper;
import neo4j.demoproj.pdfparser.util.mappers.DocumentMapper;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentDao documentDao;
    private DataPointDao dataPointDao;

    public DocumentServiceImpl(DocumentDao documentDao, DataPointDao dataPointDao) {
        this.documentDao = documentDao;
        this.dataPointDao = dataPointDao;
    }

    @Override
    public DocumentDto getDocumentById(long id) throws NoSuchDocumentException {
        return DocumentMapper.mapDocumentToDocumentDto(
                this.documentDao.findById(id).orElseThrow(new NoSuchDocumentException())
        );
    }

    @Override
    public void addDocumentToDb(MultipartFile file) throws TikaException, IOException, SAXException {
        String text= PDFWorker.extractTextFromPdf(file);

        this.documentDao.save(new Document(text));
    }

    @Override
    public List<DataPointDto> findDocumentDataPointsOfParagraphsWithTitle(long documentId, String title) throws NoSuchDocumentException {
        Document document=this.documentDao.findById(documentId).orElseThrow(NoSuchDocumentException::new);
        List<String> dataPointsTexts=PDFWorker.extractParagraphsStartedOnNumWithTitle(document.getText(),title);
        List<DataPoint> dataPointDtos=dataPointsTexts.stream()
                .map(e->new DataPoint(title,e))
                .collect(Collectors.toList());

        if(!dataPointsTexts.isEmpty()){
           dataPointDtos.stream().forEach(e->document.getDataPoints().add(e));
            this.documentDao.save(document);
        }
        return DataPointMapper.mapDataPointsToDataPointDtos(dataPointDtos);
    }
}
