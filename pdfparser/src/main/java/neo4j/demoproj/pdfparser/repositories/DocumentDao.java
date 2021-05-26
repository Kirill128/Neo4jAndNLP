package neo4j.demoproj.pdfparser.repositories;

import neo4j.demoproj.pdfparser.models.Document;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DocumentDao extends Neo4jRepository<Document,Long> {

}
