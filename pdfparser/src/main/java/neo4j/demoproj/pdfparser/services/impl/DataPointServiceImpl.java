package neo4j.demoproj.pdfparser.services.impl;

import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.repositories.DataPointDao;
import neo4j.demoproj.pdfparser.services.DataPointService;
import neo4j.demoproj.pdfparser.util.mappers.DataPointMapper;
import org.springframework.stereotype.Service;

@Service
public class DataPointServiceImpl implements DataPointService {

    private DataPointDao dataPointDao;

    public DataPointServiceImpl(DataPointDao dataPointDao) {
        this.dataPointDao = dataPointDao;
    }

    @Override
    public void addDataPointToDb(DataPointDto dataPointDto) {
        this.dataPointDao.save(
                DataPointMapper.mapDataPointDtoToDataPoint(dataPointDto));
    }

}
