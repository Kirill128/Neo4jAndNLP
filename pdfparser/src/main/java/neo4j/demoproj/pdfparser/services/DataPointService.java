package neo4j.demoproj.pdfparser.services;

import neo4j.demoproj.pdfparser.dto.DataPointDto;

public interface DataPointService {

    void addDataPointToDb(DataPointDto dataPointDto);

}
