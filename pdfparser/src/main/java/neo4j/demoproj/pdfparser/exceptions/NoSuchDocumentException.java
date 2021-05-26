package neo4j.demoproj.pdfparser.exceptions;


import java.util.function.Supplier;

public class NoSuchDocumentException extends Exception implements Supplier<NoSuchDocumentException> {
    public NoSuchDocumentException() {

    }

    @Override
    public NoSuchDocumentException get() {
        return new NoSuchDocumentException();
    }
}
