package neo4j.demoproj.pdfparser.rest;

import lombok.extern.slf4j.Slf4j;
import neo4j.demoproj.pdfparser.exceptions.NoSuchDocumentException;
import org.apache.tika.exception.TikaException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.xml.sax.SAXException;

import java.io.IOException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(NoSuchDocumentException.class)
    public String handleNoSuchDocumentException(NoSuchDocumentException exception, WebRequest request){
        log.error(exception.getLocalizedMessage());
        return "Couldn't find document";
    }

    @ExceptionHandler(TikaException.class)
    public String handleNoSuchDocumentException(TikaException exception, WebRequest request){
        log.error(exception.getLocalizedMessage());
        return "Couldn't process document";
    }
    @ExceptionHandler(IOException.class)
    public String handleNoSuchDocumentException(IOException exception, WebRequest request){
        log.error(exception.getLocalizedMessage());
        return "Couldn't process document";
    }
    @ExceptionHandler(SAXException.class)
    public String handleNoSuchDocumentException(SAXException exception, WebRequest request){
        log.error(exception.getLocalizedMessage());
        return "Couldn't process document";
    }
}
