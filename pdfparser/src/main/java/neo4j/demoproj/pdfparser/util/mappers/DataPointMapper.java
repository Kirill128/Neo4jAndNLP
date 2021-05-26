package neo4j.demoproj.pdfparser.util.mappers;

import lombok.experimental.UtilityClass;
import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.models.DataPoint;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DataPointMapper {
    public DataPointDto mapDataPointToDataPointDto(DataPoint dataPoint){
        return DataPointDto.builder()
                .id(dataPoint.getId())
                .text(dataPoint.getText())
                .build();
    }
    public List<DataPointDto> mapDataPointsToDataPointDtos(List<DataPoint> dataPoints){
        return dataPoints.stream().map(DataPointMapper::mapDataPointToDataPointDto).collect(Collectors.toList());
    }
    public DataPoint mapDataPointDtoToDataPoint(DataPointDto dataPoint){
        return DataPoint.builder()
                .id(dataPoint.getId())
                .text(dataPoint.getText())
                .build();
    }
    public List<DataPoint> mapDataPointDtosToDataPoints(List<DataPointDto> dataPoints){
        return dataPoints.stream().map(DataPointMapper::mapDataPointDtoToDataPoint).collect(Collectors.toList());
    }

}
