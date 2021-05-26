package neo4j.demoproj.pdfparser.util;

import lombok.experimental.UtilityClass;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class PDFWorker {
    public String extractTextFromPdf(MultipartFile file) throws TikaException, IOException, SAXException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler(-1);
        Metadata metadata = new Metadata();

        parser.parse(file.getInputStream(),handler,metadata,new ParseContext());
        return handler.toString();
    }
    public List<String> extractParagraphsStartedOnNumWithTitle(String text,String title){
        Pattern pattern =Pattern.compile(String.format("\n\n\\d\\.\\s*%s\\s*\\..*?\n",title),Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        List<String>results=new LinkedList<>();
        while(matcher.find()){
            results.add(text.substring(matcher.start(),text.indexOf("\n\n",matcher.end())));
        }
        return results;
    }
}
