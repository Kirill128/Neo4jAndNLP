package neo4j.demoproj.pdfparser.rest;

import neo4j.demoproj.pdfparser.dto.DataPointDto;
import neo4j.demoproj.pdfparser.services.DataPointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data-points")
public class DataPointController {
    private DataPointService dataPointService;

    public DataPointController(DataPointService dataPointService) {
        this.dataPointService = dataPointService;
    }

    @PostMapping("/{dataPointId}/add-to-dataset")
    public DataPointDto addDataPointToDb(@RequestBody Map.Entry<String,String> textLabel,
                                   @PathVariable long dataPointId){
        DataPointDto dataPointDto=DataPointDto.builder()
                .id(dataPointId)
                .key(textLabel.getKey())
                .text(textLabel.getValue())
                .build();
        this.dataPointService.addDataPointToDb(dataPointDto);
        return dataPointDto;
    }
}
