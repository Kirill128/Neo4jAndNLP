package neo4j.demoproj.pdfparser.repositories;

import neo4j.demoproj.pdfparser.models.DataPoint;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DataPointDao extends Neo4jRepository<DataPoint,Long> {

}
